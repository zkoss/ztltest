import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2942150TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2942150TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="" border="normal">
						Please click the combobox in IE, the dropdown list can\'t be shown.
					<combobox id="cb" disabled="true" readonly="true">
						<comboitem label="A"></comboitem>
						<comboitem label="B"></comboitem>
						<comboitem label="C"></comboitem>
						<comboitem label="D"></comboitem>
					</combobox>
				</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")));
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
});
