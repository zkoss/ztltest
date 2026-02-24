import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-2762TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2762.zhtml`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2762TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("title").html())()),
		)
		.eql(ztl.normalizeText("someobject"));
});
