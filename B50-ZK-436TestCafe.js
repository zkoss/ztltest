import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-436TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-436.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-436TestCafe", async (t) => {
	await ztl.initTest(t);
	let bodyHTML_cafe = await ClientFunction(() => jq("body")[0].innerHTML)();
	let first_cafe = bodyHTML_cafe.indexOf("false");
	let last_cafe = bodyHTML_cafe.lastIndexOf("false");
	let first2_cafe = bodyHTML_cafe.indexOf('"false"');
	await t
		.expect(first_cafe == last_cafe && first_cafe - first2_cafe == 1)
		.ok('the only "false" should be the one in description');
});
