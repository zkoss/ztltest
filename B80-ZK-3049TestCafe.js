import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3049TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3049.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3049TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@combobox").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await ClientFunction(() => {
		jq("@combobox").find(".z-combobox-input").focus();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@combobox")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-popup").css("display"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
	await t.click(
		Selector(() => zk.Widget.$(jq("@combobox")).$n("btn")),
		{ offsetX: 10, offsetY: 10 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-popup").css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("none"));
	await t.click(Selector(() => zk.Widget.$(jq("@combobox")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-popup").css("display"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
});
