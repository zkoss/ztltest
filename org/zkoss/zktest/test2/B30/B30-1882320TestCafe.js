import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1882320TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1882320TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">

    			<n:p>setSelectionRange won\'t work at following case due to the smartupdate. If you see the text is selected from 1 to 2, it is correct.</n:p>
    			<window id="win">

    			<zscript>

    				Textbox textboxTest = new Textbox();
    				textboxTest.setParent(win);
    				textboxTest.setValue( "0123456789" );
    				textboxTest.setSelectionRange(1,3);

    			</zscript>

    			</window>
    			
    		</zk>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1,3"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk(jq("@textbox")).getSelectionRange().toString(),
				)(),
			),
		);
});
