import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1786154TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1786154TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	expect to get 100 ~ 104 in first row, then 105 ~ 109 for next row.
	<zscript>
	int[] counts = new int[2];
	String[] labels = new String[] {"100", "101", "102", "103", "104", "105",
	"106", "107", "108", "109", "110"};
	</zscript>
	<grid>
	<rows>
	
	<row forEach="\${counts}">
		<button forEach="\${labels}"
		forEachBegin="\${forEachStatus.previous.index * 5}"
		forEachEnd="\${forEachStatus.previous.index * 5 + 4}"
		label=\'\${each} , \${forEachStatus.previous.index}\'/>
		</row>
	</rows>
	</grid>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(0)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("100 , 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(1)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("101 , 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(2)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("102 , 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(3)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("103 , 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(4)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("104 , 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(5)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("105 , 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(6)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("106 , 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(7)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("107 , 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(8)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("108 , 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@button:eq(9)")).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("109 , 1"));
});
