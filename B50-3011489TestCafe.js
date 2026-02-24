import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3011489TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3011489TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk><decimalbox format="##0.00%" value="3.5"/>
			<button label="blur"/></zk>`,
	);
	await ClientFunction(() => {
		jq(jq("@decimalbox"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@decimalbox")[0]),
		ztl.normalizeText("3.5"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox ").val())(),
			),
		)
		.eql(ztl.normalizeText("350.00%"));
});
