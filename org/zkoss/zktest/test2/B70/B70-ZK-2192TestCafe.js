import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2192TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2192TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w=\'client\'>
	<label multiline="true">
		1. Click the "Slide" button.
		2. When the window is sliding, click the combobutton.
		3. The popup should show up.
	</label>
	<button label="Slide" w:onClick="jq(this.$f(\'t\')).slideToggle(5000)" />
    <zscript><![CDATA[
        ListModelList lm = new ListModelList(Arrays.asList(new String[] { "David",
                "Thomas", "Steven"}));
    ]]></zscript>
	<combobox model="\${lm}"/>
	<window id="t" title="This is a Window" border="normal" height="400px" />
</zk>`,
	);
	await t
		.click(Selector(() => jq(".z-button")[0]))
		.click(Selector(() => zk.Widget.$(jq(".z-combobox")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => zk.Widget.$(jq(".z-combobox")).$n("pp") != null,
			)(),
		)
		.ok("The popup should show up");
});
