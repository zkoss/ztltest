import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2806414TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2806414TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please type some words into the textbox and press "Enter", you should not see any Javascript error on the browser\'s status bar.
<window  onOK=\'self.detach()\'>
<textbox onChanging=""/>
</window>
</zk>`,
	);
	await ClientFunction(() => {
		jq("input.z-textbox").focus();
	})();
	if (
		await ClientFunction(
			() => jq(jq("input.z-textbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("input.z-textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("A A A enter");
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
