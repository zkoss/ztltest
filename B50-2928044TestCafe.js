import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2928044TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2928044TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
You can not type the words more than 3.
<textbox id="txt"  maxlength="3"/>
</zk>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("txt", true).focus();
	})();
	await t.typeText(
		Selector(() => jq("$txt")[0]),
		ztl.normalizeText("AAAA"),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(jq("$txt")).val())(),
			),
		)
		.notContains(ztl.normalizeText("AAAA"), "");
});
