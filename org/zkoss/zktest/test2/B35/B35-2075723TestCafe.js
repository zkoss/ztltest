import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075723TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075723TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<zk>
<html><![CDATA[
1. minimize table 3. <br />
2. minimize table 1. <br />
3. maximize table 1, <br />
4. table 3 should be able to maximize again
]]></html>
<tablelayout id="tbl" columns="3" width="500px">
	<tablechildren id="tc1" colspan="2">
		<panel id="table1" title="table1" border="normal" maximizable="true" maximized="true"
			 collapsible="true">
			<panelchildren>
				<tablelayout columns="3">
					<tablechildren>
						<panel id="table31" title="table3" border="normal" maximizable="true" maximized="true" collapsible="true">
							<panelchildren>
								<label value="Panel3" />
							</panelchildren>
						</panel>
					</tablechildren>
				</tablelayout>
				Panel
			</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table2" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel2</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren rowspan="2">
		<panel id="table3" title="table3" border="normal" maximizable="true" maximized="true"
			 collapsible="true">
			<panelchildren>Panel3</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table4" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table5" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table6" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table7" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
	<tablechildren>
		<panel title="table8" border="normal" maximizable="true"
			collapsible="true">
			<panelchildren>Panel</panelchildren>
		</panel>
	</tablechildren>
</tablelayout>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq("$table3").find("@panel")).$n("exp")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table3")).$n("body")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(
		Selector(() => zk.Widget.$(jq("$table31").find("@panel")).$n("exp")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table31")).$n("body")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(
		Selector(() => zk.Widget.$(jq("$table1").find("@panel")).$n("exp")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table31")).$n("body")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table1")).$n("body")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(
		Selector(() => zk.Widget.$(jq("$table1").find("@panel")).$n("exp")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table1")).$n("body")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table31")).$n("body")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(
		Selector(() => zk.Widget.$(jq("$table31").find("@panel")).$n("exp")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table1")).$n("body")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table31")).$n("body")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => zk.Widget.$(jq("$table3").find("@panel")).$n("exp")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$table3")).$n("body")).is(":visible"),
			)(),
		)
		.ok();
});
