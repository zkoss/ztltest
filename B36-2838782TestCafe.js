import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2838782TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2838782.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2838782TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@treecell:contains(3)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@treerow:eq(0)")).$n("icon")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@treerow:eq(0)")).$n("icon")));
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("up");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("@treecell:contains(7)")
					.parent(".z-treerow")
					.hasClass("z-treerow-selected"),
			)(),
		)
		.ok();
});
