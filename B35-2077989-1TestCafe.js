import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2077989-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2077989-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B35-2077989.zul"/>`);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$win").is(":visible"))(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t.click(Selector(() => zk.Desktop._dt.$f("win", true).$n("min")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$win").is(":visible"))(),
			),
		)
		.eql(ztl.normalizeText("false"));
});
