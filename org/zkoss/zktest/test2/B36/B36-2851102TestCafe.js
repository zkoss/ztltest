import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2851102TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2851102.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2851102TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@toolbarbutton")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$win1").is(":visible"))())
		.ok();
});
