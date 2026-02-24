import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2165067TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2165067TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <html><![CDATA[
		<ol>
			<li>Before doing anything, you should see 3 "test" labels.</li>
			<li>Click on "Remove" Button. The "test" labels should disappear, leaving only Button 2. If not, it is a bug.</li>
		</ol>
	]]></html>
        <div id="d">
          <label value="test"/>
          <label value="test"/>
          <label value="test"/>
          <button label="Button 2"/>
        </div>
        <button label="Remove">
          <attribute name="onClick"><![CDATA[
			ListIterator it = d.getChildren().listIterator(3);
			for (int n = 3; --n >= 0;) {
				it.previous();
				it.remove();
			}
		]]></attribute>
        </button>
      </zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-label:contains(test)").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 3)
		.ok("The tree labels should does not exists");
	await t.click(Selector(() => jq("@button")[1]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-label:contains(test)").length,
	)();
	await t
		.expect(verifyVariable_cafe_1_1 == 3)
		.notOk("The tree labels should does not exists");
	await t
		.expect(
			await ClientFunction(() => !!jq("@button:contains(Button 2)")[0])(),
		)
		.ok("The button 'Button 2' should does exists");
});
