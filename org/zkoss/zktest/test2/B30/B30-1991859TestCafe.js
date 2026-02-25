import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1991859TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1991859TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="test" title="test" border="normal" height="100%">
        Please click the button, and then you should only see one alert message.
        <listbox width="400px">
          <listhead>
            <listheader label="1"/>
            <listheader label="2"/>
          </listhead>
          <listitem>
            <listcell span="2" onClick=\'alert("you cannot see this one!")\'>
              <button label="Click" onClick=\'alert("only this one!");\'/>
            </listcell>
          </listitem>
        </listbox>
      </window>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.ok("The Messagebox must be visible");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-messagebox-window").html())(),
			),
		)
		.contains(
			ztl.normalizeText("only this one!"),
			"The alert visible is not the correct",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-messagebox-window").html())(),
			),
		)
		.notContains(
			ztl.normalizeText("you cannot see this one!"),
			"The alert visible is the wrong one",
		);
});
