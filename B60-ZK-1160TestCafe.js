import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1160TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1160TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="http://www.w3.org/1999/xhtml">
  <borderlayout
    width="100%"
    height="100%"
    style="padding: 0px"
    apply="org.zkoss.zktest.test2.B60_ZK_1160_TabController">
    <north>
      <panel title="Instruction">
        <panelchildren>
          <div>1. Please click on "person" under menu.</div>
          <div>2. A tab labeled "person" with included content should appear on the right panel below.</div>
          <div>3. Close the "person" tab.</div>
          <div>4. Exception should not have occured.</div>
        </panelchildren>
      </panel>
    </north>
    <west
      width="200px"
      splittable="true"
      collapsible="true">
      <vlayout
        spacing="0"
        height="100%"
        style="overflow:auto">
        <panel title="menu">
          <panelchildren>
            <vbox>
              <toolbarbutton
                id="btnPerson"
                label="person" />
            </vbox>
          </panelchildren>
        </panel>
      </vlayout>
    </west>

    <east
      width="18%"
      splittable="true"
      visible="false" />

    <center>
      <tabbox
        id="tabMain"
        width="100%"
        height="100%">
        <tabs></tabs>
        <tabpanels></tabpanels>
      </tabbox>
    </center>
  </borderlayout>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-toolbarbutton:contains(person)")[0]));
	await ztl.waitResponse(t);
	await t.wait(1500);
	await t
		.expect(await ClientFunction(() => !!jq(".z-tab")[0])())
		.ok(" A tab labeled 'person' should appear on the right panel below.");
	await t.click(Selector(() => zk.Widget.$(jq(".z-tab")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
});
