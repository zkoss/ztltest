import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1101TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1101TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    Please click the addChild 2~3 times, you should see 2,1,0 in order, not 0, 1, 2.
                    <zscript>
                      Panel newPanel(){
                        Panel p = new Panel();
                        Panelchildren pc = new Panelchildren();
                        p.appendChild(pc);
                        pc.appendChild(new Label(ptc.getChildren().size() + ""));
                        return p;

                      }
                    </zscript>
                    <portallayout id="p">
                      <portalchildren id="ptc">
                      </portalchildren>
                    </portallayout>
                    <button label="addChild" onClick=\'p.setPanel(newPanel(), 0, 0)\'/>
                  </zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(addChild)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(addChild)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(addChild)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("210"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-panel .z-label").text().replace(/\s/g, " "),
				)(),
			),
			"should see 2,1,0 in order, not 0, 1, 2.",
		);
});
