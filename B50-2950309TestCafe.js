import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2950309TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2950309TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<datebox id="db" readonly="true" />
				<button id="btn" label="disabled" onClick="db.disabled=!db.disabled" />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(zk.Widget.$(jq(".z-datebox")).$n("pp"))).is(":visible"),
			)(),
		)
		.ok();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")))
		.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(zk.Widget.$(jq(".z-datebox")).$n("pp"))).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")))
		.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(zk.Widget.$(jq(".z-datebox")).$n("pp"))).is(":visible"),
			)(),
		)
		.ok();
});
