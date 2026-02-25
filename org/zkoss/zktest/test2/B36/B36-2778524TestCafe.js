import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2778524TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2778524TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<vbox>
					Choice date at the datebox, it should be ok (the year should not always 1999). 
					<datebox id="db1" format="dd.MM.yyyy" />
					Choice date at the datebox, it should not show any error.
					<datebox id="db2" format="dd.MM.yyyy" lenient="false" />
				</vbox>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("db1", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("db1", true).$n("pp"))
					.find("@calendar")
					.find("td:eq(12)")[0],
		),
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("db1", true).$n("real")).val(),
				)(),
			),
		)
		.notContains(ztl.normalizeText("1999"), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("db2", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("db2", true).$n("pp"))
					.find("@calendar")
					.find("td:eq(12)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t
		.expect(await ClientFunction(() => !!jq("div.z-errorbox")[0])())
		.notOk();
});
