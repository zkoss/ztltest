import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1926990TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1926990TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Btn Visibility" width="300px" border="normal">
Clicks <button label="show or hide">
<attribute name="onClick">
tb.buttonVisible = cb.buttonVisible = db.buttonVisible = bb.buttonVisible
= !tb.buttonVisible;
</attribute>
</button> and you shall see the button shown up together.
<separator bar="true"/>
<timebox id="tb" buttonVisible="false"/>
<separator/>
<combobox id="cb" buttonVisible="false"/>
<separator/>
<datebox id="db" buttonVisible="false"/>
<separator/>
<bandbox id="bb" buttonVisible="false"/>
</window>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("tb", true).$n("btn")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("cb", true).$n("btn")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("db", true).$n("btn")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("bb", true).$n("btn")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("tb", true).$n("btn")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("cb", true).$n("btn")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("db", true).$n("btn")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("bb", true).$n("btn")).is(":visible"),
			)(),
		)
		.ok();
});
