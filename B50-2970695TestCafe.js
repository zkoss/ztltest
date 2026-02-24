import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2970695TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2970695TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Check only one error box appear
	<window>
		<zscript><![CDATA[
			import org.zkoss.zul.*;
			Constraint cons = new Constraint() {
				public void validate(Component comp, Object value) throws WrongValueException {
					throw new WrongValueException(comp, "You must upload an essence file");
				}
			};
			void doValidation() {
				cons.validate(button, null);
			}
		]]></zscript>
		<button id="button" label="Button" onClick="doValidation();" />
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq("$button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 1).ok();
});
