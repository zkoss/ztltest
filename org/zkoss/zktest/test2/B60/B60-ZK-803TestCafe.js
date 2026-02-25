import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-803TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-803.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-803TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-listcell:contains(Mary)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listcell:contains(John)")[0]));
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(".z-listcell:contains(Mary)")[0]),
		120,
		20,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(
			ztl.normalizeText("Mary"),
			"should see two selected items dragged.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(
			ztl.normalizeText("John"),
			"should see two selected items dragged.",
		);
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(".z-listcell:contains(Jane)")[0]),
		120,
		20,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(
			ztl.normalizeText("Jane"),
			"should see only third item dragged.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(
			ztl.normalizeText(">>>1"),
			"should see only third item dragged.",
		);
});
