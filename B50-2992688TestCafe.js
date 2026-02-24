import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2992688TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2992688TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			    <combobox id="cb" disabled="true"/> 
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("cb", true).$n("real")).is(
					"[disabled=disabled]",
				),
			)(),
		)
		.ok();
});
