import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2746TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2746TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B70-ZK-2746.zul"/>`);
	await t.click(Selector(() => jq("@button:first")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:last")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});
