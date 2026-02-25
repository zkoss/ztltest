import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-2901TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2901.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2901TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("button")[0]));
	await t.wait(3000);
	await ztl.waitResponse(t);
	await t.wait(1000);
	await ztl.waitResponse(t);
	let itemText_cafe = await ClientFunction(() =>
		jq(".z-treecell-content .z-label").eq(0).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(itemText_cafe))
		.eql(
			ztl.normalizeText("1490"),
			"expecting 1490, got: " + itemText_cafe,
		);
});
