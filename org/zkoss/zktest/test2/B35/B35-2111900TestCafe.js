import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2111900TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2111900TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="The onChanging event" border="normal">
	Please type some words in the textbox, then the instant-copy should work well.
	<grid width="80%">
	<rows>
		<row>onChanging textbox: <textbox multiline="true" rows="2"  onChanging="copy.value = event.value"/></row>
		<row>instant copy: <textbox id="copy" readonly="true"/></row>
	</rows>
	</grid>
</window>`,
	);
	await t.typeText(
		Selector(() => jq("@textbox")[0]),
		ztl.normalizeText("i am tester~happy~tester~~"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("copy", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("i am tester~happy~tester~~"));
});
