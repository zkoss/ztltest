import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1822564TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1822564TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Column should can resize by drag when start with no row.
It still doesn\'t work even add row after creation.
	<zscript>
	void addRow1(){
		Row row = new Row();
		row.setParent(rows);
		new Label("Label x").setParent(row);
		new Textbox().setParent(row);
		new Datebox().setParent(row);
	};

	</zscript>
	<vbox>
		<div width="500px">
			<button id="btn1" label="add row(end)" onClick="addRow1()"/>
			<button id="btn2" label="setColumnWidth1" onClick=\'col1.setWidth("20px")\'/>
			<button id="btn3" label="setColumnWidth2" onClick=\'col1.setWidth("100px")\'/>
			<button id="btn4" label="setColumnWidth3" onClick=\'col1.setWidth("200px")\'/>
		</div>
		<grid id="g1" width="400px" sizedByContent="false">
			<columns id="cols" sizable="true">
				<column label="Type 50px" id="col1"  align="center" width="50px" style="position:relative;"/>
				<column label="Content" id="col2" align="right"  style="position:relative;"/>
				<column label="AA-BB" id="col3"  style="position:relative;"/>
			</columns>
			<rows id="rows">
			</rows>
		</grid>
	</vbox>
</zk>`,
	);
	let w_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(w_cafe + 10 + ",0");

	let cafeCoord_2 = await ztl.convertCoordStrToArr(w_cafe + ",0", true);

	await t.drag(
		Selector(() => zk.Desktop._dt.$f("col1", true).$n()),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	w_cafe = w_cafe + 10;
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
	)();
	await t.expect(w_cafe <= verifyVariable_cafe_0_0).ok();
	await t
		.wait(1000)
		.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let cafeCoord_3 = await ztl.convertCoordStrToArr(w_cafe + 10 + ",0");

	let cafeCoord_4 = await ztl.convertCoordStrToArr(w_cafe + ",0", true);

	await t.drag(
		Selector(() => zk.Desktop._dt.$f("col1", true).$n()),
		cafeCoord_3[0] - cafeCoord_4[0],
		cafeCoord_3[1] - cafeCoord_4[1],
		{ offsetX: cafeCoord_4[0], offsetY: cafeCoord_4[1] },
	);
	w_cafe = w_cafe + 10;
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
	)();
	await t.expect(w_cafe <= verifyVariable_cafe_1_1).ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
	)();
	await t.expect(20 <= verifyVariable_cafe_2_2).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq("@row")).firstChild.$n("chdextr"),
					).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
	)();
	await t.expect(100 >= verifyVariable_cafe_3_3).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq("@row")).firstChild.$n("chdextr"),
					).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn4", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
	)();
	await t.expect(200 >= verifyVariable_cafe_4_4).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq("@row")).firstChild.$n("chdextr"),
					).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("col1", true)).outerWidth(),
				)(),
			),
		);
});
