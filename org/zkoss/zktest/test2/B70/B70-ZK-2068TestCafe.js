import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2068TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2068TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="Portallayout" contentType="text/html;charset=UTF-8"?>
<zk>
	<window border="normal" title="Portallayout">
		<label multiline="true">
			1.Click "resize",the yellow area will change width.
			2.Resize browser window, the width of yellow area will not be changed.
		</label>
		<button id="btn" label="resize" onClick="click()"/>
		<portallayout>
	    	<portalchildren id="child1" style="background-color:yellow;" height="450px"  width="30%"/>
	    	<portalchildren style="background-color:blue;" height="450px" width="30%"/>
	        <portalchildren style="background-color:green;" height="450px"  width="30%"/>
		</portallayout>
		<zscript>
			public void click(){
			  	child1.setWidth("25px");
			}
		</zscript>
	</window>
</zk>`,
	);
	let w_cafe = await ClientFunction(() => jq(".z-portalchildren").width())();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-portalchildren").width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 != w_cafe)
		.ok("the yellow area will change width");
});
