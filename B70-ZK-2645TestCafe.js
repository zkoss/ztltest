import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2645TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2645TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    <zscript><![CDATA[
    ListModelList model = new ListModelList();
    for (int j = 1; j < 201; ++j) {
        model.add("" + j);
    }
    void reset() {
        model.clear();
        for (int j = 1; j < 201; ++j) {
            model.add("" + j);
        }
    }
    ]]></zscript>
    <label multiline="true">
    1. Scroll the listbox to most bottom.
    2. Click "Reset" button.
    The listbox scroll position go back to top most but the data didn\'t show.
    This issue only happened when ROD enabled.
    </label>
    <window>
        <button label="Reset" onClick="reset()" />
        <listbox width="100%" height="400px" model="\${model}">
            <custom-attributes org.zkoss.zul.listbox.rod="true" />
            <listhead>
                <listheader label="A" />
            </listhead>
        </listbox>
    </window>
</zk>`,
	);
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox")[0]),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listbox-body").children().first().css("display"),
				)(),
			),
		);
});
