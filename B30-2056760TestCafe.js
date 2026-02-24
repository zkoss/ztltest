import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2056760TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2056760TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Please click the "setWidth 350" button, then the width of each column of the listbox will recalculate.
	<listbox id="listbox" width="250px">
		<listhead sizable="true">
			<listheader label="name" sort="auto" />
			<listheader label="gender" sort="auto" />
		</listhead>
		<listitem>
			<listcell label="Mary" />
			<listcell label="FEMALE" />
		</listitem>
		<listitem>
			<listcell label="John" />
			<listcell label="MALE" />
		</listitem>
		<listitem>
			<listcell label="Jane" />
			<listcell label="FEMALE" />
		</listitem>
		<listitem>
			<listcell label="Henry" />
			<listcell label="MALE" />
		</listitem>
	</listbox>
	<button label="setWidth 350">
		<attribute name="onClick">listbox.setWidth("350px");</attribute>
	</button>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@listbox").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("250"));
	let header_cafe = await ClientFunction(() =>
		jq("@listheader:eq(0)").width(),
	)();
	let header1_cafe = await ClientFunction(() =>
		jq("@listheader:eq(1)").width(),
	)();
	let column_cafe = await ClientFunction(() =>
		jq("@listcell:eq(0)").width(),
	)();
	let column1_cafe = await ClientFunction(() =>
		jq("@listcell:eq(1)").width(),
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let headerx_cafe = await ClientFunction(() =>
		jq("@listheader:eq(0)").width(),
	)();
	let header1x_cafe = await ClientFunction(() =>
		jq("@listheader:eq(1)").width(),
	)();
	let columnx_cafe = await ClientFunction(() =>
		jq("@listcell:eq(0)").width(),
	)();
	let column1x_cafe = await ClientFunction(() =>
		jq("@listcell:eq(1)").width(),
	)();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@listbox").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("350"));
	await t
		.expect(ztl.normalizeText(headerx_cafe - header_cafe))
		.eql(ztl.normalizeText("50"));
	await t
		.expect(ztl.normalizeText(header1x_cafe - header1_cafe))
		.eql(ztl.normalizeText("50"));
	await t
		.expect(ztl.normalizeText(columnx_cafe - column_cafe))
		.eql(ztl.normalizeText("50"));
	await t
		.expect(ztl.normalizeText(column1x_cafe - column1_cafe))
		.eql(ztl.normalizeText("50"));
});
