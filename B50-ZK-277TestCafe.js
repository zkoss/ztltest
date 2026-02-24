import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-277TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-277TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
					<ol>
						<li>Click "Change to Renderer 1", and you shall see "option 1", "option 2", and so on in the Listbox.</li>
						<li>Click "Change to Renderer 2", and you shall see "plan 1", "plan 2", and so on in the Listbox.</li>
					</ol>
				]]></html>
				<zscript><![CDATA[
					String[] data = new String[30];
					for (int j = 0; j < data.length; ++j)
						data[j] = "" + j;
					ListModel strset = new SimpleListModel(data);
					ListitemRenderer renderl1 = new ListitemRenderer() {
						public void render(Listitem item, Object data, int index) {
							item.setLabel("option " + data);
						}
					};
					ListitemRenderer renderl2 = new ListitemRenderer() {
						public void render(Listitem item, Object data, int index) {
							item.setLabel("plan " + data);
						}
					};
				]]></zscript>
				<listbox id="list" width="200px" rows="10" model="\${strset}">
					<listhead>
						<listheader label="Load on Demend" sort="auto" />
					</listhead>
				</listbox>
				<button id="btn1" label="Change to Renderer 1" onClick="list.setItemRenderer(renderl1);" />
				<button id="btn2" label="Change to Renderer 2" onClick="list.setItemRenderer(renderl2);" />
			</zk>`,
	);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("btn1", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(1)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(3)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(4)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(5)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(6)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(7)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(8)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(9)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 9"));
	await t.click(
		Selector(() => zk.Desktop._dt.$f("btn2", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(1)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(3)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(4)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(5)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(6)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(7)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(8)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("rows"))
						.find(".z-listcell")
						.eq(9)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 9"));
});
