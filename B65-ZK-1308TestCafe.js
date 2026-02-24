import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1308TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1308TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window apply="org.zkoss.zktest.test2.B65_ZK_1308_1">
You should see Super and Subclass without <label value="null" style="font-weight:bold"/> value.
<separator/>
</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(Super):eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("null"),
			"You should see Super and Subclass without 'null' value",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(Subclass):eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("null"),
			"You should see Super and Subclass without 'null' value",
		);
});
