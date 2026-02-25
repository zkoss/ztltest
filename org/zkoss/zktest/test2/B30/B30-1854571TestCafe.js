import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1854571TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1854571TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					<window id="myWin" title="Messagebox demo" border="normal">
						First, click the Test button. After four seconds, a message box appears.
						Then, you shall be able to close the message box by clicking the button.
						However, in 3.0.1, you have to click twice.
						<button id="myBtn" label="Test" width="100px">
						<attribute name="onClick">{
						Thread.sleep(4000);
						alert("See if you can close it in only click");
						}</attribute>
						</button>
					</window>
				</zk>`,
	);
	await t.click(Selector(() => jq(zk.Desktop._dt.$f("myBtn", true))[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.ok();
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-messagebox-window")).$n("close")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.notOk();
});
