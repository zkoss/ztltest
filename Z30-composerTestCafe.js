import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-composerTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-composerTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="winO" title="Original" apply="org.zkoss.zktest.test2.MyComposer">
	You shall see the title starting with "Composer: ", and with a border.
	<window id="win1" title="You shall not see this" apply="org.zkoss.zktest.test2.VoidComposer">
	Something wrong if you saw this
	</window>
	<zscript>
	voidComposer = new org.zkoss.zktest.test2.VoidComposer();
	</zscript>
	<window id="win2"  title="You shall not see this 2" apply="org.zkoss.zktest.test2.MyComposer, \${voidComposer}">
	Something wrong if you saw this
	</window>
</window>`,
	);
	await t.expect(ztl.normalizeText("0")).eql(ztl.normalizeText("0"));
	await t.expect(ztl.normalizeText("0")).eql(ztl.normalizeText("0"));
	await t
		.expect(ztl.normalizeText("Composer: Original"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$winO")).getTitle(),
				)(),
			),
		);
});
