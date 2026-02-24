import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2188572TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2188572TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				There shall be two listbox (side-by-side)
				The first listbox has two items, and the second has three items.
				<hbox>
				<zscript>
				classes = new String[] {"College", "Graduate"};
				grades = new Object[] {
				new String[] {"Best", "Better"}, new String[] {"A++", "A+", "A"}
				};
				</zscript>
			
				<listbox width="200px" forEach="\${classes}" >
					<listhead>
					<listheader label="\${each}: \${forEachStatus.index}"/>
					</listhead>
					<listitem label="\${forEachStatus.previous.current}: \${each}"
						forEach="\${grades[forEachStatus.index]}"/>
					</listbox>
				</hbox>
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(0) .z-listheader")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("College: 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(0) .z-listcell:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("College: Best"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(0) .z-listcell:eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("College: Better"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(0) .z-listcell:eq(2)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-listbox:eq(0) .z-listcell").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(1) .z-listheader")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Graduate: 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(1) .z-listcell:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Graduate: A++"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(1) .z-listcell:eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Graduate: A+"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(1) .z-listcell:eq(2)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Graduate: A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox:eq(1) .z-listcell:eq(3)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-listbox:eq(1) .z-listcell").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
});
