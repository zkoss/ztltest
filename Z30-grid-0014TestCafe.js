import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-grid-0014TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-grid-0014TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
			<window>
				<grid id="grid" width="300px" mold="paging" pageSize="5">
					<columns>
					
						<column label="Head 1"/>
						<column label="Head 2" align="center"/>
						<column label="Head 3" align="right"/>
					</columns>
					<rows>
					</rows>
				</grid>
				<button id="btnAdd" label="add 5 children" onClick="add(5)"/>
				<button id="btnChangeFirst" label="Change the first label" onClick="changeLabel(0)"/>
				<button id="btnChangeLast" label="Change the last label" onClick="changeLabel(-1)"/>
				<button id="btnInvalide" label="redraw" onClick="grid.invalidate()"/>
				<button id="btnPaging" label="set page size to 10" onClick="grid.paginal.pageSize = 10"/>
				<zscript><![CDATA[
				void add(int cnt) {
					for (int j = 0; ++j <= cnt;) {
						Row r = new Row();
						String prefix = "Item " + (grid.getRows().getChildren().size() + 1);
						new Label(prefix + "-L").setParent(r);
						new Label(prefix + "-C").setParent(r);
						new Label(prefix + "-R").setParent(r);
						r.setParent(grid.getRows());
					}
				}
				void changeLabel(int j) {
					int sz = grid.getRows().getChildren().size();
					if (j < 0) j = sz - 1;
					if (j < 0 || j >= sz) {
						alert("No label to change");
					} else {
						Row r = grid.getRows().getChildren().get(j);
						r.getChildren().get(0).setValue("Updated "+j);
					}
				}
				]]></zscript>
			</window>`,
	);
	await t
		.expect(ztl.normalizeText("0"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t
		.expect(await ClientFunction(() => jq("@paging").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("$btnAdd")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("5"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t.click(Selector(() => jq("$btnChangeFirst")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Updated 0"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row-content:first .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAdd")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@paging").is(":visible"))())
		.ok();
	await t
		.expect(ztl.normalizeText("5"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t.click(Selector(() => jq("$btnChangeLast")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$btnInvalide")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("5"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t.click(Selector(() => jq("$btnInvalide")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("5"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t.click(Selector(() => jq("$btnInvalide")[0]));
	await ztl.waitResponse(t);
});
