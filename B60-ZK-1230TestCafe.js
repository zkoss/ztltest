import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1230TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1230TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <button label="showPage">
                      <attribute name="onClick">
                        <![CDATA[
      drillList.getChildren().clear();
      for (int i = 0; i < 2; i++) {
        Listitem li = new Listitem();
        li.appendChild(new Listcell("trackName " + i));
        drillList.appendChild(li);
      }
      pages.setSelectedIndex(1);
    ]]>
                      </attribute>
                    </button>
                    <tabbox id="pages" hflex="1" vflex="1">
                      <tabs height="50px">
                        <tab label="instruction"/>
                        <tab label="result"/>
                      </tabs>
                      <tabpanels>
                        <tabpanel>
                          <html>
                            <ol>
                              <li>Click on \'showPage\' button.</li>
                              <li>You should see in the \'result\' tab, a list of 2 items: "trackName 0" and "trackName 1".</li>
                              <li>If not, that\'s an error.</li>
                            </ol>
                          </html>
                        </tabpanel>
                        <tabpanel>
                          <listbox id="drillList" height="500px"/>
                        </tabpanel>
                      </tabpanels>
                    </tabbox>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button:contains(showPage)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-tab:contains(result)").hasClass("z-tab-selected"),
			)(),
		)
		.ok("should see in the 'result' tab");
	await t
		.expect(ztl.normalizeText("block"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tabpanel:eq(1)").css("display"),
				)(),
			),
			"should see in the 'result' tab",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listitem:contains(trackName 0)")[0],
			)(),
		)
		.ok("should see 'trackName 0'");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listitem:contains(trackName 1)")[0],
			)(),
		)
		.ok("should see 'trackName 1'");
});
