import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1650TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1650TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. Should see no extra space above green Textbox.
	2. Click \'show/hide\' button, should see space between two Textboxes.
	3. Click \'show/hide\' button again, should see no extra space above green Textbox.
	</label>
	<separator />
	<vlayout style="background-color: orange">
		<textbox id="v1" visible="false" value="Text" style="background-color: cyan" />
		<label visible="false" />
		<grid visible="false" />
		<label visible="false" />
		<grid visible="false" />
		<label visible="false" />
		<grid visible="false" />
		<textbox value="Text" style="background-color: green" />
	</vlayout>
	<button label="show/hide" onClick=\'v1.setVisible(!v1.isVisible())\' />
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-vlayout").height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-textbox[style*=green]").parent().height(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == verifyVariable_cafe_1_1)
		.ok("Should see no extra space above green Textbox.");
	await t.click(Selector(() => jq(".z-button:contains(show/hide)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(".z-vlayout").height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-textbox[style*=green]").parent().height(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(".z-textbox[style*=cyan]").parent().height(),
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2 >
				verifyVariable_cafe_3_3 + verifyVariable_cafe_4_4,
		)
		.ok("should see space between two Textboxes.");
	await t.click(Selector(() => jq(".z-button:contains(show/hide)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(".z-vlayout").height(),
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq(".z-textbox[style*=green]").parent().height(),
	)();
	await t
		.expect(verifyVariable_cafe_5_5 == verifyVariable_cafe_6_6)
		.ok("should see no extra space above green Textbox");
});
