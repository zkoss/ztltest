import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3152754TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3152754TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click on Show + Invalidate, if Div Content is not shown it is a bug.</li>
			<li>Click on Hide + Invalidate and then Show + Invalidate, if Div Content is not shown it is a bug.</li>
		</ol>
	]]></html>
	<div id="inc" visible="false">
		<window border="normal">
			<label value="Div Content" />
		</window>
	</div>
	<div>
		<button label="Show + Invalidate" onClick=\'inc.visible = true; inc.invalidate();\' />
		<button label="Hide + Invalidate" onClick=\'inc.visible = false; inc.invalidate();\' />
	</div>
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(zk.Desktop._dt.$f("inc", true))).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(zk.Desktop._dt.$f("inc", true))).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(zk.Desktop._dt.$f("inc", true))).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(zk.Desktop._dt.$f("inc", true))).is(":visible"),
			)(),
		)
		.ok();
});
