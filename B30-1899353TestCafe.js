import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1899353TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1899353TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?component name="B1899353" macro-uri="B1899353.zul"
    				class="B1899353"?>
    		<zk>
    			<zscript>
    				public class B1899353 extends HtmlMacroComponent{
    					public B1899353() {
    						setMacroURI("/test2/B1899353.zul");
    					}	
    				}
    			</zscript>
    			<window title="Test" border="normal">
    				<attribute name="onCreate">
    				B1899353 b = new B1899353();
    				b.afterCompose();
    				b.setParent(test1);
    				</attribute>
    				If you see this page, the bug is fixed.
    				<vbox id="test1"/>
    			</window>
    		</zk>`,
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$test1")[0])()).ok();
});
