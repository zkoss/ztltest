import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2779TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2779.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2779TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("selection count after unchecked is 22"));
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				"selection count after unchecked is 22\nselection count after unchecked is 11",
			),
		);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				"selection count after unchecked is 22\nselection count after unchecked is 11\nselection count after unchecked is 0",
			),
		);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				"selection count after unchecked is 22\nselection count after unchecked is 11\nselection count after unchecked is 0\nselection count after unchecked is 11",
			),
		);
});
