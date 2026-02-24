import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2139542TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2139542TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<hbox>
	<datebox id="db" />
	<button label="Click Me without error, that is correct!" onClick=\'db.setFormat("dd-MMM-yyyy")\'/>
</hbox>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("db", true).$n("real").focus();
	})();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("db", true).$n("real")),
		ztl.normalizeText("asd"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
