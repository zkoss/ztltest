import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2138131TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2138131TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<zscript><![CDATA[
//@DECLARATION
public class MyComposer extends org.zkoss.zk.ui.util.GenericForwardComposer {
	public void onClick$btn() {
		alert("Hi! w2.");
	}
}
]]>
MyComposer mycomp = new MyComposer();
</zscript>
<html><![CDATA[
<p>Load this page and there is no exception message, then it is correct.</p>               
]]>
</html>
<window title="ztl" id="w2" apply="\${mycomp}">
	<label value="Hello! GenericForwardComposer"/>
</window>
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq('@window:not(@window[title="ztl"])')[0],
			)(),
		)
		.notOk();
});
