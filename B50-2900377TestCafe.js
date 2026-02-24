import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2900377TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2900377TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				You should see the panel is closed.
				<panel id="panel" title="Panel" border="normal" collapsible="true" open="false">
				<panelchildren>
				<label>test</label>
				</panelchildren>
				</panel>
				</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-panel")).$n("body")).css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("none"));
});
