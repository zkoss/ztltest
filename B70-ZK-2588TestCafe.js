import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2588TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2588.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2588TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-treecell").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treecell").last()[0]));
	await ztl.waitResponse(t);
	let before_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Widget.$(jq("@tree")).$n()),
	});
	await t.click(Selector(() => jq(".z-treecell").last()[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ztl.getScrollTop({
				locator: Selector(() => zk.Widget.$(jq("@tree")).$n()),
			}),
		),
		ztl.normalizeText(before_cafe),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq(".z-listcell").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listcell").last()[0]));
	await ztl.waitResponse(t);
	before_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
	});
	await t.click(Selector(() => jq(".z-listcell").last()[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ztl.getScrollTop({
				locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
			}),
		),
		ztl.normalizeText(before_cafe),
		ztl.normalizeText("1"),
	);
});
