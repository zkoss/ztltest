import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-373TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-373TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
				1. Please scroll to the middle of the list, and then press the button "Refresh !".
				<separator/>
				2. You should see the list reset to the top of the list and display well.
				<button id="btnRefresh" label="Refresh !">
					<attribute name="onClick">
					 list.setModel(new org.zkoss.zktest.test2.grid.FakeListModel(200));
					 grid.setModel(new org.zkoss.zktest.test2.grid.FakeListModel(200));
					</attribute>
				</button>
				<zscript>
					ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(2000);
				</zscript>
				<listbox id="list" width="200px" rows="10" model="&#36;{strset}">
					<listhead>
						<listheader label="Load on Demend" sort="auto"/>
					</listhead>
				</listbox>
				<grid id="grid" width="200px" height="300px" model="&#36;{strset}">
					<columns>
						<column label="Load on Demend" sort="auto"/>
					</columns>
				</grid>
			</window>`,
	);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("list", true).$n()),
		scrollType: "vertical",
		percent: "0.5",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "vertical",
		percent: "0.5",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnRefresh", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("list", true).$n("body")).scrollTop(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("grid", true).$n("body")).scrollTop(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
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
		.contains(ztl.normalizeText("Option 0"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("grid", true).$n("body"))
						.find(".z-row")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("0"), "");
});
