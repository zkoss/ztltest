import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-804TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-804TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>
                      1. Click on the button. You should NOT see javascript Exception.
                    </div>
                    <button label="Go">
                      <attribute name="onClick"><![CDATA[
			Tabpanels tps = new Tabpanels();
			tps.parent = tabbox;
			Tabpanel tp = new Tabpanel();
			tp.parent = tps;
			tp.appendChild(new Label("Tabpanel Content"));
		]]></attribute>
                    </button>
                    <tabbox id="tabbox">
                      <tabs>
                        <tab label="Tab"/>
                      </tabs>
                    </tabbox>
                  </zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(Go)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript Exception");
});
