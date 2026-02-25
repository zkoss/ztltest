import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2607TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2607.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2607TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-selectbox option").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-selectbox option").eq(0).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("renderer1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-selectbox option").eq(1).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("renderer1"));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-selectbox option").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-selectbox option").eq(0).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("renderer2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-selectbox option").eq(1).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("renderer2"));
});
