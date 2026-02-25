import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2148979TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2148979TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window border="normal" width="350px" sizable="true" minimizable="true"
	maximizable="true" closable="true">
	<caption image="/test2/img/inet.png"
		label="You should see three tool icons here" />
</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-window-icon").length)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@window")).$n("max")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@window")).$n("min")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@window")).$n("close")).is(":visible"),
			)(),
		)
		.ok();
});
