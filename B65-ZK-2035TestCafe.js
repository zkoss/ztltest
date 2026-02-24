import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-2035TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-2035.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-2035TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-panel")).$n("exp")));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should not see error message");
});
