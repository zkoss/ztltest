import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2509TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2509TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    <custom-attributes org.zkoss.zul.nativebar="true"/>
    <label multiline="true">
    1. scroll to right most.
    2. scroll back to left.
    3. you should not see the column with tiny width 
    </label>
    <zscript><![CDATA[
    Object[] columns = new Object[50];
    ]]></zscript>
    <grid width="500px">
        <frozen columns="1" />
        <columns>
            <column label="2200" align="center" hflex="min" forEach="\${columns}" />
        </columns>
        <rows>
            <row forEach="1,2,3,4,5,6">
                <label value="5" forEach="\${columns}" />
            </row>
        </rows>
    </grid>
</zk>`,
	);
	let cwidth_cafe = await ClientFunction(() =>
		jq(jq(".z-column")[2]).width(),
	)();
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "2860.0";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-grid")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "-2860.0";
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(jq(".z-column")[2]).width(),
	)();
	await t.expect(verifyVariable_cafe_0_0 == cwidth_cafe).ok();
});
