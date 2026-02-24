import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1823959TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1823959TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="http://www.w3.org/1999/xhtml">
        <h:h3> [ 1823959 ] Grid failed to re-sync model (Opera/IE/IE7)</h:h3>
        <h:pre>
          In IE/IE7/Opera, JavaScript error when re-sync model multiple times.
(If you cannot see any JavaScript error, the bug is fixed)
        </h:pre>
        <zscript>
          ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(1);
        </zscript>
        <vbox>
          <button label="Resync Model" onClick="strset.invalidate()"/>
          <grid model="\${strset}">
            <columns sizable="true">
              <column label="Type"/>
            </columns>
          </grid>
        </vbox>
      </zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
