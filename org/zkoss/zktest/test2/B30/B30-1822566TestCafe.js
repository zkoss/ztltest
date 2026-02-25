import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1822566TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1822566TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<zscript>
	void addRow1(){
		Row row = new Row();
		row.setParent(rows);
		new Label("Label x").setParent(row);
		new Textbox().setParent(row);
		new Datebox().setParent(row);
	};
	
	</zscript>
             1. Click set button to set Cloumn Width 
             <separator/>
	If Column set Width doesn\'t work correctly  try click <button label="fixedLayout=&quot;true&quot;" onClick="g1.fixedLayout=true"/> then run 1 again
             <separator/>


	<vbox>
		<hbox width="500px">
			<button id="btn1" label="setColumnWidth1" onClick=\'col1.setWidth("20px")\'/>
			<button id="btn2" label="setColumnWidth2" onClick=\'col1.setWidth("100px")\'/>
			<button id="btn3" label="setColumnWidth3" onClick=\'col1.setWidth("200px")\'/>
		</hbox>
		<grid id="g1" width="400px" height="100px">
			<columns id="cols">
				<column label="Type 50px" id="col1"  align="center" width="50px"/>
				<column label="Content" id="col2" align="right"/>
				<column label="AA-BB" id="col3"/>
			</columns>
			<rows id="rows">
			<row><textbox/><textbox/><textbox/>
			</row>
			</rows>
		</grid>
	</vbox>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("20"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row-inner:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("20"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("100"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row-inner:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("100"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("200"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row-inner:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("200"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("100"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row-inner:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("100"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true).$n()).outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("20"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row-inner:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("20"));
});
