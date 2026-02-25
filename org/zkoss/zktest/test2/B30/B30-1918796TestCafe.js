import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1918796TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1918796TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:p>Grid header should disappear in this case.</n:p>
        <window width="250px">
          <groupbox visible="false" id="gpb">
            <caption label="caption"/>
            <grid>
              <columns>
                <column/>
              </columns>
              <rows>
                <row>Test:</row>
              </rows>
            </grid>
          </groupbox>
          <button label="Show Hide 2nd groupbox" onClick="gpb.setVisible(!gpb.isVisible())"/>
        </window>
      </zk>`,
	);
	await t
		.expect(await ClientFunction(() => jq("@grid").is(":visible"))())
		.notOk("grid should not be visible");
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@grid").is(":visible"))())
		.ok("grid should be visible");
});
