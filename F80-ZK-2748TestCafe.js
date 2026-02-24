import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F80-ZK-2748TestCafe`
	.page`http://localhost:8080/zktest/test2/F80-ZK-2748.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F80-ZK-2748TestCafe", async (t) => {
	await ztl.initTest(t);
	let lb1_cafe = await ClientFunction(() => jq("@label")[1].offsetTop)();
	let lb2_cafe = await ClientFunction(() => jq("@label")[2].offsetTop)();
	await t
		.expect(ztl.normalizeText(lb2_cafe))
		.eql(ztl.normalizeText(lb1_cafe));
});
