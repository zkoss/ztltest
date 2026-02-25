import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1338TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1338.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1338TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.wait(5000);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("mainWin", true) &&
					!!zk.Desktop._dt.$f("mainWin", true).$n(),
			)(),
		)
		.ok("Window should be there!");
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
});
