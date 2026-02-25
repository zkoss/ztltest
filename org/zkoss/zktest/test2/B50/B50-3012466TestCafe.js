import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3012466TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3012466TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please select \'a\' or \'b\', you should see the result as you selected.
<listbox mold="select" onSelect="self.selectedItem.invalidate();">
<listitem label="a"/>
<listitem label="b"/>
<listitem label="c" selected="true"/>
</listbox>
</zk>`,
	);
	await t
		.click(Selector(() => jq(jq("@select"))[0]))
		.click(Selector(() => jq(jq("@select")).find("option:contains(b)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("b"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@select")
						.find("option:selected")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.click(Selector(() => jq(jq("@select"))[0]))
		.click(Selector(() => jq(jq("@select")).find("option:contains(a)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("a"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@select")
						.find("option:selected")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
