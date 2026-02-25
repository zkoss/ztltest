import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2776TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2776.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2776TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.hover(Selector(() => jq("@grid").find(".z-column").first()[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq("@grid").find(".z-column").first()).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(
					".z-menupopup-open .z-menupopup-content .z-menuitem-checkable",
				)[3],
		),
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(2860);
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(-2860);
	})();
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-column:first").outerWidth(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-rows .z-row:first .z-cell:first").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-column:eq(1)").outerWidth(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-rows .z-row:first .z-cell:eq(1)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-column:eq(2)").outerWidth(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-rows .z-row:first .z-cell:eq(2)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-column:eq(4)").outerWidth(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@grid .z-rows .z-row:first .z-cell:eq(4)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
});
