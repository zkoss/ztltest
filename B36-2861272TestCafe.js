import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2861272TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2861272TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	You should see both item "One" and "Three" into the list.
	<listbox rows="1" mold="select">
	<listitem label="One"/>
	<listitem label="Two" visible="false"/>
	<listitem label="Three"/>
	</listbox>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("select option").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("select option:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("One"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("select option:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Three"));
});
