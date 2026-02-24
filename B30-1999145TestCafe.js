import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1999145TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1999145TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    			You should see the width of combobox is stretch to 100% with its button. 
    			<window border="normal">
    				<combobox width="100%" >
    					<comboitem label="Simple and Rich"/>
    					<comboitem label="Cool!"/>
    					<comboitem label="Thumbs Up!"/>
    				</combobox>
    			</window>
    		</zk>`,
	);
	await ztl.waitResponse(t);
	let cw_cafe = await ClientFunction(() => jq("@combobox:eq(0)").width())();
	let pw_cafe = await ClientFunction(() =>
		jq("@combobox:eq(0)").parent().width(),
	)();
	await t.expect(ztl.normalizeText(pw_cafe)).eql(ztl.normalizeText(cw_cafe));
});
