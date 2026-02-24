import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1989387TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1989387.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1989387TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
});
