import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2933235TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2933235TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Hello World!!" border="normal" width="400px">

    <combobox id="contentCbx" rows="1" cols="1" readonly="true" width="50px">
        <comboitem label="AAAAAAAAAAAAAAAAAAAAAAAAAAAAA" />
        <comboitem label="BBBBBBBBBBBBBBB" />
        <comboitem label="CBBB" />
    </combobox>

    <button label="Click me to change width that it should work.">
        <attribute name="onClick">
            contentCbx.setWidth("200px");
        </attribute>
    </button>
</window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$contentCbx").css("width"))(),
			),
		)
		.eql(ztl.normalizeText("200px"));
});
