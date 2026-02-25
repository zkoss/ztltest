import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2086352TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2086352TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	1. Click "doHighlighted" button.
	<separator />
	2. Minimize window.
	<separator />
	3. If the mask still appears, that is wrong.
	<button onClick="win.doHighlighted()" label="doHighlighted" />

	<window id="win" title="Window Component" width="300px" minimizable="true"
		border="normal">
	</window>
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => zk.Desktop._dt.$f("win", true).$n("mask") != null,
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => zk.Desktop._dt.$f("win", true).$n("mask") != null,
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("win", true).$n("min")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => zk.Desktop._dt.$f("win", true).$n("mask") != null,
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("win", true).$n("mask")).is(":visible"),
			)(),
		)
		.notOk();
});
