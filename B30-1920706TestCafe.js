import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1920706TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1920706TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>[Set width of grid column doesn\'t work correctly (Opera only)]</n:p>
				<zscript><![CDATA[
void addRow1(){
Row row = new Row();
row.setParent(rows);
new Label("Label x").setParent(row);
new Textbox().setParent(row);
new Datebox().setParent(row);
};
]]></zscript>
				Column set Width doesn\'t work correctly
				<vbox>
					<div width="500px">
						<button label="setColumnWidth1" onClick=\'col1.setWidth("20px")\'/>
						<button label="setColumnWidth2" onClick=\'col1.setWidth("100px")\'/>
						<button label="setColumnWidth3" onClick=\'col1.setWidth("200px")\'/>
					</div>
					<grid id="g1" width="400px">
						<columns id="cols">
							<column label="Type 50px" id="col1" align="center" width="50px"/>
							<column label="Content" id="col2" align="right"/>
							<column label="AA-BB" id="col3"/>
						</columns>
						<rows id="rows">
							<row>
								<textbox/><textbox/><textbox/>
							</row>
						</rows>
					</grid>
				</vbox>
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$col1").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("50"));
	let halfWidth_cafe_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("g1", true)).innerWidth(),
	)();
	let halfWidth_cafe = (halfWidth_cafe_0 - 50) / 2;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col2").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col3").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("20"),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col1").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	let halfWidth_cafe_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("g1", true)).innerWidth(),
	)();
	let halfWidth_cafe_2 = await ClientFunction(() =>
		jq("$col1").outerWidth(),
	)();
	halfWidth_cafe = (halfWidth_cafe_1 - halfWidth_cafe_2) / 2;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col2").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col3").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("100"),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col1").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	let halfWidth_cafe_1t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("g1", true)).innerWidth(),
	)();
	let halfWidth_cafe_2t = await ClientFunction(() =>
		jq("$col1").outerWidth(),
	)();
	halfWidth_cafe = (halfWidth_cafe_1t - halfWidth_cafe_2t) / 2;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col2").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col3").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("200"),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col1").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	let halfWidth_cafe_1tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("g1", true)).innerWidth(),
	)();
	let halfWidth_cafe_2tt = await ClientFunction(() =>
		jq("$col1").outerWidth(),
	)();
	halfWidth_cafe = (halfWidth_cafe_1tt - halfWidth_cafe_2tt) / 2;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col2").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(halfWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("$col3").outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
});
