import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3583TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3583.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3583TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.expect(await ClientFunction(() => !!jq(".z-popup")[0])()).notOk();
	await t.hover(Selector(() => jq(".z-div").eq(1)[0])).wait(1000);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-popup")[0])()).ok();
	await t.hover(Selector(() => jq(".z-button")[0])).wait(1000);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-popup").css("display"))(),
			),
		)
		.eql(ztl.normalizeText("block"));
});
