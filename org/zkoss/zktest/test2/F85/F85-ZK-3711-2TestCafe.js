import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F85-ZK-3711-2TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3711-2.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3711-2TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9")) {
		console.log("This issue is ignored in current browser! (ie9)");
		return;
	}
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	const log = Selector("#zk_log");
	await ClientFunction(() => {
		window.history.back();
	})();
	await ztl.waitResponse(t);
	await t.expect(log.value).contains('{"f1":1,', "It should be f1=1.");
	await ClientFunction(() => {
		window.history.forward();
	})();
	await ztl.waitResponse(t);
	await t.expect(log.value).contains('{"f1":3,', "It should be f1=3.");
});
