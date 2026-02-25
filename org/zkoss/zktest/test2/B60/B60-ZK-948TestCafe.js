import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-948TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-948TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>1. Click on the \'Do modal\' button.</div>
				<div>2. Check selectbox has data. Select some value. Close the window.</div>
				<div>3. Click on the \'Do modal\' button again. Window should be displayed. Check selectbox has data and the selected value.</div>
				<div>4. Close the window.</div>
				<div>5. Click on the \'move to first window\' button, the selectbox should appear after the \'Do modal\' button.</div>
				<div>6. Check selectbox has data and the selected value.</div>
				<div>7. Click on the \'move to second window\' button, the selectbox should appear below the \'Do modal\' button.</div>
				<div>8. Check selectbox has data and the selected value.</div>
				<div>9. Click on the \'attach to page directly\' button, the selectbox should appear after the \'attach to page directly\' button.</div>
				<div>10. Check selectbox has data and the selected value.</div>
    			<label id="lb1" value="lb1" />
				<zscript><![CDATA[
					//@IMPORT
					import org.zkoss.zk.ui.event.EventListener;
					//@DECLARATION
					Window win = null;
    				Label lb2 = null;
					Selectbox selBox = null;
					public class MyListener implements EventListener{
						public void onEvent(Event evt) throws Exception{
							if (win == null) {
								String[] userName = { "Tony", "Ryan", "Jumper", "Wing", "Sam" };
								ListModelList model = new ListModelList(userName);
								selBox = new Selectbox();
								selBox.setModel(model);
    							selBox.setId("sbx");
    							lb2 = new Label();
    							lb2.setId("lb2");
    							lb2.setValue("lb2");
								win = new Window();
								win.setTitle("Hello!");
								win.setClosable(true);
								win.appendChild(lb2);
    							win.appendChild(selBox);
							} 
				       
							win.setParent(mainWindow);
							win.doModal();
						}
					}
				]]></zscript>
				<window id="mainWindow">
					<button id="btn1">Do modal
						<attribute name="onCreate">
							self.addEventListener("onClick", new MyListener(){});
						</attribute>
					</button>
				</window>
				<window id="secondWindow">
			
				</window>
				<button id="btn2">move to modal window
					<attribute name="onClick">
						if (selBox != null) {
							selBox.setParent(win);
							lb2.setParent(win);
						}
					</attribute>
				</button>
				<button id="btn3">move to first window
					<attribute name="onClick">
						if (selBox != null)
							selBox.setParent(mainWindow);
					</attribute>
				</button>
				<button id="btn4">move to second window
					<attribute name="onClick">
						if (selBox != null)
							selBox.setParent(secondWindow);
					</attribute>
				</button>
				<button id="btn5">attach to page directly
					<attribute name="onClick">
						selBox.setParent(null);
						selBox.setPage(mainWindow.getPage());
					</attribute>
				</button>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq(zk.Desktop._dt.$f("sbx", true))[0]))
		.click(
			Selector(
				() =>
					jq(zk.Desktop._dt.$f("sbx", true)).find(
						"option:contains(Tony)",
					)[0],
			),
		);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("sbx", true)).find("option").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 5).ok("Select box has items");
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-window-modal")).$n("close")),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("sbx", true)).find("option").length,
	)();
	await t.expect(verifyVariable_cafe_0_0t == 5).ok("Select box has items");
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-window-modal")).$n("close")),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("sbx", true)).find("option").length,
	)();
	await t.expect(verifyVariable_cafe_0_0tt == 5).ok("Select box has items");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn4", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("sbx", true)).find("option").length,
	)();
	await t.expect(verifyVariable_cafe_0_0ttt == 5).ok("Select box has items");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn5", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("sbx", true)).find("option").length,
	)();
	await t.expect(verifyVariable_cafe_0_0tttt == 5).ok("Select box has items");
});
