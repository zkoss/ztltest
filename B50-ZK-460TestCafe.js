import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-460TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-460TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>Click on the up/down button of Spinner/Timebox. 
				The value should NOT be shown immediately on the right. 
				(i.e. onChange shall NOT be fire upon clicking on up/down button.)</div>
				<listbox width="350px">
					<listitem>
						<listcell>
							<spinner onChange=\'lc1.label = event.value\' />
						</listcell>
						<listcell id="lc1" />
					</listitem>
					<listitem>
						<listcell>
							<timebox onChange=\'lc2.label = event.value\' />
						</listcell>
						<listcell id="lc2" />
					</listitem>
				</listbox>
			</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-spinner")).$n("btn-up")));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lc1", true)).val(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Widget.$(jq(".z-spinner")).$n("btn-down")));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lc1", true)).val(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Widget.$(jq(".z-timebox")).$n("btn-up")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-timebox")).$n("btn-up")));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lc2", true)).val(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Widget.$(jq(".z-timebox")).$n("btn-down")));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lc2", true)).val(),
				)(),
			),
		);
});
