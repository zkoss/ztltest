import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-grid-0002TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-grid-0002TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
				<label id="lab"/>
				
				<separator/>
				This testcase test the click event in grid column, column1 handle onClick, column2 handle rightClick, column3 handle double click, 
				column4 handle click and rightclick and doublelclick
				<separator/>
				it also test the resize of column
				<button label="invalidate" onClick="g.invalidate()"/>
				<button label="alert" onClick=\'alert("Try")\'/>
				<label id="label"/>
				<grid id="g" width="500px">
					<columns id="cs" sizable="true" onColSize=\'lab.value=new java.util.Date()+"col size change:"+event+",colindex:"+event.getColIndex()\'>
						<column label="AA" id="col1" onClick=\'label.value = "Click on column 1";\'/>
						<column label="BB" id="col2" onRightClick=\'label.value = "onRightClick on column 2";\'/>
						<column label="CC" id="col3" onDoubleClick=\'label.value = "onDoubleClick on column 3";\'/>
						<column label="DD" id="col4" onClick=\'label.value = "Click on column 4"\' onRightClick=\'label.value = "onRightClick on column 4";\' onDoubleClick=\'label.value = "onDoubleClick on column 4";\'/>
						<column label="EE" id="col5" />
					</columns>
					<rows>
						<row>
							<label value="AA01" />
							<label value="BB01" />
							<label value="CC01" />
							<label value="DD01" />
							<label value="EE01" />
						</row>
						<row>
							<label value="AA02" />
							<label value="BB02" />
							<label value="CC02" />
							<label value="DD02" />
							<label value="EE02" />
						</row>
					</rows>
				</grid>
			</vbox>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("col1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("label", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Click on column 1"));
	await t.rightClick(Selector(() => zk.Desktop._dt.$f("col2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("label", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("onRightClick on column 2"));
	await t.doubleClick(Selector(() => zk.Desktop._dt.$f("col3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("label", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("onDoubleClick on column 3"));
	await t.click(Selector(() => zk.Desktop._dt.$f("col4", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("label", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Click on column 4"));
	await t.rightClick(Selector(() => zk.Desktop._dt.$f("col4", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("label", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("onRightClick on column 4"));
	await t.doubleClick(Selector(() => zk.Desktop._dt.$f("col4", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("label", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("onDoubleClick on column 4"));
});
