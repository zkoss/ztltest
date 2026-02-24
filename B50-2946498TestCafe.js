import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2946498TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2946498TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="My First Window" border="normal" width="400px"
				mode="highlighted" closable="true">
				    <zscript>
				        public void errorAll() {
							List wves = new ArrayList();
							wves.add(new WrongValueException(txb1, "error txb1"));
							wves.add(new WrongValueException(ltb, "error on ltb"));
							wves.add(new WrongValueException(txb2, "error txb2"));
							throw new WrongValuesException(wves.toArray(new WrongValueException[1]));							
						}
				    </zscript>
				    <separator spacing="40px" />
				    <vbox>
				        <textbox id="txb1" />
				        <listbox id="ltb" mold="select" />
				        <textbox id="txb2" />
				    </vbox>
				    <separator/>
				    <button id="x" label="Click me first, and than close the window via (X icon)" onClick="errorAll()"/>
				    You should see all of the popup windows with errors are closed.
				</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("x", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox").length)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t.click(
		Selector(() =>
			zk.Widget.$(jq("@window.z-window-highlighted")).$n("close"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
});
