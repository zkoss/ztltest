import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-909TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-909TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8" ?>
                  <zk>
                    <div>step 1: click on save button without entering any data (you should see errorbox message)</div>
                    <div>step 2: close errorbox1 and then errorbox2 (if you reverse the closing sequence then it will not cause this issue)</div>
                    <div>step 3: enter some text into first textbox</div>
                    <div>step 4: click on save again, the value of first textbox should not be cleared.</div>
                    <vlayout>
                      <hlayout>
                        <label value="First textbox"></label>
                        <textbox id="periodValue"></textbox>
                      </hlayout>
                      <hlayout>
                        <label value="Second textbox"></label>
                        <textbox id="periodValue1"></textbox>
                      </hlayout>
                      <button id="b" label="save">
                        <attribute name="onClick"><![CDATA[
				import java.util.ArrayList;
				
				import org.zkoss.lang.Strings;
				import org.zkoss.zk.ui.WrongValueException;
				import org.zkoss.zk.ui.WrongValuesException;
				
				ArrayList wve = new ArrayList();
				if(Strings.isEmpty(periodValue.getValue())) {
					wve.add(new WrongValueException(periodValue, "Empty not allowed 1"));
				}
				if(Strings.isEmpty(periodValue1.getValue())) {
					wve.add(new WrongValueException(periodValue1, "Empty not allowed 2"));
				}
				if (wve.size() > 0) {
					WrongValueException[] wvea = new WrongValueException[wve.size()];
					for (int i = 0; i < wve.size(); i++) {
						wvea[i] = (WrongValueException) wve.get(i);
					}
					throw new WrongValuesException(wvea);
				}			
			  ]]></attribute>
                      </button>
                    </vlayout>
                  </zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(save)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.ok("should see errorbox message");
	await t.click(Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")));
	await ztl.waitResponse(t);
	await t
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")));
	await ztl.waitResponse(t);
	await t.wait(500);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("should not see errorbox message");
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox:eq(0)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 1 1 1");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(save)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox:eq(0)").val())(),
			),
		)
		.contains(
			ztl.normalizeText("1111"),
			"the value of first textbox should not be cleared.",
		);
});
