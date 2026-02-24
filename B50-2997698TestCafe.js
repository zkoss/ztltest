import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2997698TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2997698TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Decimalbox Test" border="normal" width="500px">
<html>
<![CDATA[
<ol>
<li>If you see the numbers before the textbox are the same of in the textbox, then it is OK.</li>
<li>Otherwise, it is a bug</li>
</ol>
]]>
</html>
<hbox>% 1,235<decimalbox format="\'%\' #,##0" value="1234.56"/></hbox>
<hbox>% 1,235<decimalbox format="% #,##0" value="12.3456"/></hbox>
<hbox># 1,234.6<decimalbox format="\'#\' #,##0.0" value="1234.56"/></hbox>
</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@window @decimalbox:eq(0)").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("% 1,235"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@window @decimalbox:eq(1)").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("% 1,235"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@window @decimalbox:eq(2)").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("# 1,234.6"));
});
