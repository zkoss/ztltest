import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1216TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1216TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="B60-ZK-1216" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <window title="B60-ZK-1216" border="normal" mode="overlapped" position="center">
                      <html>
                        Please expand the combo-button below and click on one of the buttons in the popup window.<br/>
                        The label for the combo-button should change to match that for the button clicked.<br/>
                      </html>
                      <combobutton id="comboBtn" label="open me">
                        <popup>
                          <vlayout>
                            <button id="btn1" label="click me" onClick="comboBtn.label = self.label"></button>
                            <button id="btn2" label="or me" onClick="comboBtn.label = self.label"></button>
                            <button id="btn3" label="me too!" onClick="comboBtn.label = self.label"></button>
                          </vlayout>
                        </popup>
                      </combobutton>
                    </window>
                  </zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-combobutton")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(click me)")[0]));
	await ztl.waitResponse(t);
	await t.expect(ztl.normalizeText("click me")).eql(
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobutton")).$n("real"))
					.text()
					.replace(/\s/g, " "),
			)(),
		),
		"The label for the combo-button should change to match that for the button clicked.",
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-combobutton")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(or me)")[0]));
	await ztl.waitResponse(t);
	await t.expect(ztl.normalizeText("or me")).eql(
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobutton")).$n("real"))
					.text()
					.replace(/\s/g, " "),
			)(),
		),
		"The label for the combo-button should change to match that for the button clicked.",
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-combobutton")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(me too!)")[0]));
	await ztl.waitResponse(t);
	await t.expect(ztl.normalizeText("me too!")).eql(
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobutton")).$n("real"))
					.text()
					.replace(/\s/g, " "),
			)(),
		),
		"The label for the combo-button should change to match that for the button clicked.",
	);
});
