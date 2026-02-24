//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1898094TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1898094TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await ztl.runZscript(
		t,
		`<zk>        
    			If you see the focus be at the textbox (rather than button), It is fixed.
    			<window title="Test Popup Focus" mode="popup" width="300px" >
    			<button label="Button"/>
    				<textbox onCreate="self.focus()"/>
    			</window>
    		</zk>`,
	);
	await t.wait(1000);
	let bb_cafe = await ClientFunction(() => !!jq("@textbox:focus")[0])();
	let br_cafe = await ClientFunction(() => !!jq("@button:focus")[0])();
	await t.expect(bb_cafe).ok();
	await t.expect(br_cafe).notOk();
});
