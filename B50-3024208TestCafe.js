import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3024208TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3024208TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html>
<![CDATA[
<ol>
	<li>Check that the icon of datebox button does not move up when mouseover</li>
</ol>
]]>
</html>
<datebox id="d"/>
</zk>`,
	);
	let x_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("d", true).$n("btn")).offset().left,
	)();
	await t
		.hover(Selector(() => zk.Desktop._dt.$f("d", true).$n("btn")))
		.wait(500);
	let x1_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("d", true).$n("btn")).offset().left,
	)();
	await t.expect(ztl.normalizeText(x1_cafe)).eql(ztl.normalizeText(x_cafe));
});
