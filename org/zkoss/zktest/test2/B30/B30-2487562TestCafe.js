import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2487562TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2487562TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Listbox" border="normal">
        Please press HOME and END on the keyboard, you should see that the cursor in the input element works well. (Firefox 3 only)
        <listbox rows="2">
          <listitem>
            <listcell>
              <textbox value="Jerry" width="150px" focus="true"/>
            </listcell>
          </listitem>
          <listitem label="Inbox"/>
          <listitem label="Received"/>
          <listitem label="Draft"/>
        </listbox>
      </window>`,
	);
	await t.pressKey("home");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@textbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.pressKey("end");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@textbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
});
