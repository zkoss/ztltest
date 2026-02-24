import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3035897TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3035897TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
<html><![CDATA[<ol>
<li>type or paste \'100%\', it shall become to \'1\'</li>
</ol>
	]]></html>
	<textbox value="100%" />
<longbox/>
</window>`,
	);
	await t.typeText(
		Selector(() => jq("@longbox")[0]),
		ztl.normalizeText("100%"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@longbox").val())(),
			),
		)
		.eql(ztl.normalizeText("1"));
});
