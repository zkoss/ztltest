import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3284149TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3284149TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Open the datebox.</li>
			<li>Click the timebox in datebox popup.</li>
			<li>The time shall not changed.</li>
		</ol>
	]]></html>
	<datebox format="yyyy-MM-dd HH:mm:ss" readonly="true"/>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("@datebox")).$n("btn")));
	await ztl.waitResponse(t);
	let x_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-timebox")).$n("real")).val(),
	)();
	await ClientFunction(() => {
		jq(zk.Widget.$(jq(".z-timebox")).$n("real")).focus();
	})();
	await ztl.waitResponse(t);
	let x1_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-timebox")).$n("real")).val(),
	)();
	await t.expect(ztl.normalizeText(x1_cafe)).eql(ztl.normalizeText(x_cafe));
});
