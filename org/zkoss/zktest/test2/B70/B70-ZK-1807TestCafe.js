import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-1807TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-1807TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="Bandbox Style Change" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Bandbox Style Change" border="normal">
		<label>
		Click "test", each component width won\'t change.
		</label>
		<vbox width="500px">
			<bandbox hflex="1" id="bandbox"/>
			<datebox hflex="min" id="datebox"/>
			<spinner id="spinner"/>
			<combobox width="300px" id="combobox">
				<comboitem label="value"/>
			</combobox>
			<button label="test" onClick="doClick()"/>
			<zscript>
				void doClick() {
					bandbox.setStyle("background-color:yellow;");
					datebox.setStyle("background-color:yellow;");
					spinner.setStyle("background-color:yellow;");
					combobox.setStyle("background-color:yellow;");
				}
			</zscript>
		</vbox>
	</window>
</zk>`,
	);
	let w1_cafe = await ClientFunction(() => jq(".z-bandbox").width())();
	let w2_cafe = await ClientFunction(() => jq(".z-datebox").width())();
	let w3_cafe = await ClientFunction(() => jq(".z-spinner").width())();
	let w4_cafe = await ClientFunction(() => jq(".z-combobox").width())();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-bandbox").width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-spinner").width(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(".z-combobox").width(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-datebox").width(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 == w1_cafe &&
				verifyVariable_cafe_3_3 == w2_cafe &&
				verifyVariable_cafe_1_1 == w3_cafe &&
				verifyVariable_cafe_2_2 == w4_cafe,
		)
		.ok("each component width won't change.");
});
