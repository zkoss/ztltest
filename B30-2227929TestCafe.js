import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2227929TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2227929TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window border="normal">
        Click
        <button label="Create">
          <attribute name="onClick"><![CDATA[
	newc = execution.createComponents("/test2/B30-2227929_inc.zul", null);
		]]></attribute>
        </button>
        and you shall see nothing happen.
	Then click<button label="Attach" onClick="newc[0].setParent(self.parent)"/>
        and you shall see a group of components are appended
      </window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(zk.Widget.$(jq(".z-window-embedded")).$n("cave")).find(
						":contains(Created Dynamically)",
					)[0],
			)(),
		)
		.notOk(
			'The window with header "Created Dynamically" should not be visible',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@textbox").attr("value"))(),
			),
		)
		.notEql(ztl.normalizeText("2227929"), "");
	await t.click(Selector(() => jq("@button")[1]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(zk.Widget.$(jq(".z-window-embedded")).$n("cave")).find(
						":contains(Created Dynamically)",
					)[0],
			)(),
		)
		.ok('The window with header "Created Dynamically" should be visible');
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@textbox").attr("value"))(),
			),
		)
		.eql(ztl.normalizeText("2227929"), "");
});
