import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-1996TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-1996TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Click Navitem Label" border="normal" width="300px" height="300px">
<navbar id="nb" collapsed="false">
	<navitem label="Click me!" onClick=\'msg.appendChild(new Label("[click]"));\' iconSclass="z-icon-flag"/>
</navbar>
Click on the "Click me!", it would show [click] once:
<div id="msg">
</div>
</window>`,
	);
	await t.click(Selector(() => jq(".z-navitem")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-div .z-label:contains([click])").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 1)
		.ok("it would show [click] once");
});
