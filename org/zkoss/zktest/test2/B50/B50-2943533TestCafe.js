import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2943533TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2943533TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="" border="normal" width="400">
			    <grid>
			        <columns id="cols" sizable="true" menupopup="auto" >
			            <column label="A" />
			            <column label="B" />
			            <column label="C" />
			            <column label="D" />
			        </columns>
			        <rows>
			            <row>
			                <cell>
			                    <label value="a" />
			                </cell>
			                <cell>
			                    <label value="b" />
			                </cell>
			                <cell>
			                    <label value="c" />
			                </cell>
			                <cell>
			                    <label value="d" />
			                </cell>
			            </row>
			        </rows>
			    </grid>
			    <button id="btn" label="Click me should alert a message."></button>
			    <zscript><![CDATA[
			        import org.zkoss.zk.ui.event.EventListener;
			import org.zkoss.zk.ui.event.Events;
			
			btn.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event arg0) throws Exception {
			Messagebox.show("If you can see the message, the bug is fixed.");
			}
			});
			    ]]></zscript>
			</window>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.ok();
});
