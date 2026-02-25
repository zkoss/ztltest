import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-725TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-725.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-725TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq("@column:eq(0)")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq(".z-row")[0].id)()),
		)
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row")[0].id)()),
			"should sorted correctly",
		);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq(".z-row")[1].id)()),
		)
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row")[1].id)()),
			"should sorted correctly",
		);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq(".z-row")[2].id)()),
		)
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row")[2].id)()),
			"should sorted correctly",
		);
});
