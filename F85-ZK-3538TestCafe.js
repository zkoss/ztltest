//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F85-ZK-3538TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3538.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3538TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ff")) {
		console.log("This issue is ignored in current browser! (ff)");
		return;
	}
	await t.typeText(
		Selector(() => jq(".z-textbox")[0]),
		ztl.normalizeText("ch"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-textbox").is(":focus"))())
		.ok();
	await t.click(Selector(() => jq(".z-tree-icon:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("tree is on focus"));
});
