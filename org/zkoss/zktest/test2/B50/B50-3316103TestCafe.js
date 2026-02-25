import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3316103TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3316103TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>
					This test case requires to specify the following in zk.xml:
					<![CDATA[
					<listener>
						<listener-class>org.zkoss.zkmax.au.InaccessibleWidgetBlockService$DesktopInit</listener-class>
					</listener>
					]]>
				</div>
				<div>
					1. Select an item from the Combobox. You should see text appearing on the right. Otherwise it is a bug.
				</div>
				<div>
					2. Pick a date in the Datebox. You should see text appearing on the right. Otherwise it is a bug.
				</div>
				<hlayout>
					<combobox id="cbx" readonly="true" onChange="label2.setValue(self.getRawText())">
						<comboitem label="1" />
						<comboitem label="2" />
						<comboitem label="3" />
					</combobox>
					<label id="label2" />
				</hlayout>
				<hlayout>
					<datebox id="dbx" readonly="true" onChange="label3.setValue(self.getRawText())" />
					<label id="label3" />
				</hlayout>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cbx", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("cbx", true).$n("pp")).find(
					".z-comboitem",
				)[1],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("label2", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("cbx", true).$n("real").value,
				)(),
			),
			"the value of combobox should equal to the label text next to it",
		);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("dbx", true).$n("btn")))
		.click(
			Selector(
				() =>
					jq(zk.Desktop._dt.$f("dbx", true).$n("pp")).find(
						".z-calendar-weekday",
					)[10],
			),
		);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("label3", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("dbx", true).$n("real").value,
				)(),
			),
			"the value of datebox should equal to the label text next to it",
		);
});
