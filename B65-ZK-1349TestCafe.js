import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1349TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1349TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <label multiline="true">
                      1. Click "show" button.
    				  2. Should see a blue background cell.
                    </label>
                    <grid width="60ex">
                      <columns>
                        <column label="Arabic numeral"/>
                        <column id="col2" label="Capital letter" visible="false"/>
                        <column label="Roman numeral"/>
                      </columns>
                      <rows>
                        <row>
                          <cell>
                            <label value="1"/>
                          </cell>
                          <cell style="white-space: nowrap; background-color: cyan;">
                            <label value="A"/>
                          </cell>
                          <cell>
                            <label value="I"/>
                          </cell>
                        </row>
                      </rows>
                    </grid>
                    <button label="show" onClick="col2.setVisible(true)"/>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let color_cafe = await ClientFunction(() =>
		jq(".z-cell:contains(A)").css("background-color"),
	)();
	let isCyan_cafe = color_cafe == "cyan" || color_cafe == "rgb(0, 255, 255)";
	await t.expect(isCyan_cafe).ok("Should see a blue background cell.");
});
