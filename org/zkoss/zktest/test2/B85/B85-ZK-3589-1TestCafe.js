import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3589-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B85-ZK-3589-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B85-ZK-3589.zul"/>`);
	await ClientFunction(() => {
		window.scroll(0, 300);
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@label")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@popup").is(":visible"))())
		.ok("The popup should appear!");
	await t.click(Selector(() => jq("$btnFixed")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@popup").is(":visible"))())
		.notOk("The popup still appears!");
});
