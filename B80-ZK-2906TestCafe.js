import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-2906TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2906.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2906TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-chosenbox-input")[0]));
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-chosenbox-input")[0]),
		ztl.normalizeText("'`&<>\""),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let itemText_cafe = await ClientFunction(() =>
		jq(".z-chosenbox-empty span").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(itemText_cafe))
		.eql(
			ztl.normalizeText("Create new contact ''`&<>\"'"),
			"expecting '`&<>\", got: " + itemText_cafe,
		);
});
