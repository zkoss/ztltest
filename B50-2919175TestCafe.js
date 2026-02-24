import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2919175TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2919175TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
1. select Cool!
<separator/>
2. type abc into combobox
<separator/>
3. tab away
<separator/>
4. It should not complain "This field should not be empty ...."
<combobox constraint="no empty">
<comboitem label="Simple and Rich" />
<comboitem label="Cool!" />
<comboitem label="Thumbs Up!" />
</combobox>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-combobox")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@comboitem[label="Cool!"]')[0]));
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Widget.$(jq(".z-combobox")).$n("real")),
		ztl.normalizeText("abc"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
});
