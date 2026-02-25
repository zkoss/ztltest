import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1217TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1217TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<label multiline="true"><![CDATA[
1. Please click upon "Contacts" to close the groupbox, and then open/close panel or borderlayout\'s north.
2. Please click upon "Contacts" to open the groupbox, and then its content shouldn\'t be hidden.
]]></label>
	<panel title="panel" border="normal" width="100px"
		collapsible="true">
		<panelchildren>
			<groupbox mold="3d" height="100%">
				<caption label="Contacts" />
				<div>a</div>
				<div>a</div>
			</groupbox>
		</panelchildren>
	</panel>
	
	<borderlayout  width="100px">
		<west title="north" collapsible="true">
			<div>
				<groupbox mold="3d" height="100%">
					<caption label="Contacts" />
					<div>a</div>
					<div>a</div>
				</groupbox>
			</div>
		</west>
	</borderlayout>
</zk>`,
	);
	let block_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-groupbox:eq(0)")).$n("cave")).css("display"),
	)();
	await t.click(Selector(() => jq("@caption:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(ztl.normalizeText(block_cafe))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-groupbox:eq(0)")).$n("cave")).css(
						"display",
					),
				)(),
			),
			"panel or borderlayout should be open/close",
		);
	await t.click(Selector(() => jq("@caption:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(ztl.normalizeText(block_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-groupbox:eq(0)")).$n("cave")).css(
						"display",
					),
				)(),
			),
			"its content shouldn't be hidden",
		);
	let block_cafet = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-groupbox:eq(1)")).$n("cave")).css("display"),
	)();
	await t.click(Selector(() => jq("@caption:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(ztl.normalizeText(block_cafet))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-groupbox:eq(1)")).$n("cave")).css(
						"display",
					),
				)(),
			),
			"panel or borderlayout should be open/close",
		);
	await t.click(Selector(() => jq("@caption:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(ztl.normalizeText(block_cafet))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-groupbox:eq(1)")).$n("cave")).css(
						"display",
					),
				)(),
			),
			"its content shouldn't be hidden",
		);
});
