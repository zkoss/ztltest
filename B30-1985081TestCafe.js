import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1985081TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1985081TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="select bug" border="normal">
        Press the button, then the "Select Me!!!" label will be selected.
        <vbox>
          <hbox id="hbox">
            <label id="lb" value="Select Me!!!"/>
          </hbox>
          <button label="press" onClick="onClick()"/>
        </vbox>
        <zscript>
          <![CDATA[
          import org.zkoss.zul.Textbox;
public void onClick(){
            Textbox tb = new Textbox();
            tb.setValue(lb.getValue());
            tb.setParent(hbox);
            lb.setVisible(false);
            tb.focus();
            tb.select();
          }
        ]]>
        </zscript>
      </window>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("lb", true)).is(":visible"),
			)(),
		)
		.ok("The label Select Me!!! must be visible");
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("lb", true)).is(":visible"),
			)(),
		)
		.notOk("The label should be invisible");
	await t
		.expect(await ClientFunction(() => jq(".z-textbox").is(":visible"))())
		.ok("The textbox Select Me!!! must be visible");
});
