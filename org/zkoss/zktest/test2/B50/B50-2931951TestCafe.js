import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2931951TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2931951TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<div>
Please click addRow button, than you should see a paging toolbar.
	<grid id="grid" mold="paging" height="60px">
		<columns>
			<column label="column1" align="Center" />
			<column label="column2" align="Center" />
			<column label="column3" align="Center" />
			<column label="column4" align="Center" />
			<column label="column5" align="Center" />
			<column label="column6" align="Center" />
		</columns>
		<rows id="rows">
			<row forEach="0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9">
				<label value="column1" />
				<label value="column2" />
				<label value="column3" />
				<label value="column4" />
				<label value="column5" />
				<label value="column6" />
			</row>
		</rows>
	</grid>
	<button label="addRow">
		<attribute name="onClick">
			Row rw = new Row(); rw.setParent(rows); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
		</attribute>
	</button>
</div>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("grid", true).paging).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("grid", true).paging).is(":visible"),
			)(),
		)
		.ok();
});
