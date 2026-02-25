import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2534TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2534TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<custom-attributes org.zkoss.zul.listbox.rod="false" />
	<listbox multiple="true" checkmark="true">
		<listhead>
			<listheader hflex="min" />
			<listheader label="Name" />
		</listhead>
		<listitem>
			<listcell />
			<listcell label="David" />
		</listitem>
		<listitem selectable="false">
			<listcell />
			<listcell label="Thomas" />
		</listitem>
		<listitem>
			<listcell />
			<listcell label="Lukas" />
		</listitem>
		<listitem selectable="false">
			<listcell />
			<listcell label="Jens" />
		</listitem>
	</listbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-listheader-checkable")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:even").eq(0).attr("class"),
				)(),
			),
		)
		.contains(ztl.normalizeText("z-listitem-selected"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:even").eq(1).attr("class"),
				)(),
			),
		)
		.contains(ztl.normalizeText("z-listitem-selected"), "");
});
