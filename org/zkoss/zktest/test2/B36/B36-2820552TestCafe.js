import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2820552TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2820552.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2820552TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
