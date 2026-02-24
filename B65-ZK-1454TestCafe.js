import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1454TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1454.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1454TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(1):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(3):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(7):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(15):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(31):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(63):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(127):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(255):eq(0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-tabpanel")[0].scrollTop = 28;
	})();
	await t.click(Selector(() => jq(".z-tab:contains(2)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tab:contains(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("28"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tabpanel").scrollTop())(),
			),
			"The scrollbar should be at the previous position",
		);
});
