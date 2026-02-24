import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2794303TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2794303.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2794303TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@panel").find("i").length)(),
			),
		)
		.eql(ztl.normalizeText("4"));
});
