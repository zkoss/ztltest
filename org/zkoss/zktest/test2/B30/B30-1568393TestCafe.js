import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1568393TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1568393TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test" id="root">
			1. keep on clicking on the title-bar of the overlapped-window(not on the "close_button")
			<separator/>
			2. sometimes the window jumps to the upper right corner without dragging it.(If not, it is right)
			<zscript><![CDATA[
			public class ContentPanel extends Window implements EventListener{
				private Caption top;
				private Label closeLabel;
			
				public ContentPanel(){
					init0();
				}
			
				private void init0(){
					top = new Caption();
					top.setStyle("cursor:hand;");
				
					closeLabel = new Label();
					Label l = closeLabel;
					l.setValue("CLOSE X");
					//l.setId(ImageLoader.IMG_MINI);
					l.addEventListener("onClick", this);
				
					l.setStyle("cusror:position; cursor:hand;");
					top.appendChild(l);
					appendChild(top);	
				}
			
				public boolean setVisible(boolean v){
					if(!inOverlapped())
						doOverlapped();
					return super.setVisible(v);
				}
			
			
				public void onEvent(Event arg0) {
					if(arg0.getName().equals("onClick") &&
					(arg0.getTarget() instanceof Component) ){
						super.setVisible(false);
						arg0.stopPropagation();
						//EventHandler.get().notifyObservers(this, new CloseEvent());
					}
				}
			}
			
			
				ContentPanel cp = new ContentPanel();
				cp.setId("overlapped");
				cp.setTitle("hello");
				cp.setStyle("width: 400px; max-width: 400px; height: 350px; max-height: 350px; top:25%; left: 25%; position:absolute;");
				cp.setParent(root);
				cp.doOverlapped();
			]]></zscript>
			</window>`,
	);
	let x_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("overlapped", true)).position().left,
	)();
	let y_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("overlapped", true)).position().top,
	)();
	await t
		.drag(
			Selector(() => zk.Desktop._dt.$f("overlapped", true).$n()),
			1,
			0,
			{ offsetX: 11, offsetY: 2 },
		)
		.drag(
			Selector(() => zk.Desktop._dt.$f("overlapped", true).$n()),
			1,
			0,
			{ offsetX: 12, offsetY: 2 },
		)
		.drag(
			Selector(() => zk.Desktop._dt.$f("overlapped", true).$n()),
			1,
			0,
			{ offsetX: 13, offsetY: 2 },
		)
		.drag(
			Selector(() => zk.Desktop._dt.$f("overlapped", true).$n()),
			1,
			0,
			{ offsetX: 14, offsetY: 2 },
		)
		.drag(
			Selector(() => zk.Desktop._dt.$f("overlapped", true).$n()),
			1,
			0,
			{ offsetX: 15, offsetY: 2 },
		);
	let x2_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("overlapped", true)).position().left,
	)();
	let y2_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("overlapped", true)).position().top,
	)();
	await t.expect(ztl.normalizeText(x2_cafe)).eql(ztl.normalizeText(x_cafe));
	await t.expect(ztl.normalizeText(y2_cafe)).eql(ztl.normalizeText(y_cafe));
});
