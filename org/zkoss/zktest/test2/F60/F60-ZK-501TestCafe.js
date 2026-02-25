import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-501TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-501TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    		<zscript>
    		session.setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, new Locale("en_US"));
    		</zscript>
			<html><![CDATA[
			<ul>
				<li>Click the Test button to open a message box.</li>
				<li>Then, you shall see the first button is labelled as "Yes, it is correct", and the second button is "No"</li>
			</ul>
			]]></html>
			
			<button label="Test" id="btn"
			onClick=\'Messagebox.show("Yes and No", "Test",
				new Messagebox.Button[] {Messagebox.Button.YES, Messagebox.Button.NO},
				new String[] {"Yes, it is correct"},
				Messagebox.INFORMATION, null, null)\'/>
			
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-messagebox-window").find(".z-button:contains(No)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() =>
			jq(".z-messagebox-window")
				.find(".z-button:contains(Yes, it is correct)")
				.offset().left,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() =>
			!!jq(".z-messagebox-window").find(
				".z-button:contains(Yes, it is correct)",
			)[0],
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(No)").offset()
				.left,
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2 &&
				verifyVariable_cafe_0_0 &&
				verifyVariable_cafe_1_1 < verifyVariable_cafe_3_3,
		)
		.ok(
			'you shall see the first button is labelled as "Yes, it is correct", and the second button is "No"',
		);
});
