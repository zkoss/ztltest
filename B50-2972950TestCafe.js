import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2972950TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2972950TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					<html><![CDATA[
					<ul>
					<li>Click the add constraint button and that shall not have any JavaScript error</li>
					<li>Type -1 to the input box and press TAB. Then, an error message will show up</li>
					</ul>
					]]></html>
					<intbox id="intbox" />
					<button id="btn" label="add constraint"
					onClick="intbox.constraint = new SimpleConstraint(SimpleConstraint.NO_NEGATIVE)" />
				</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("intbox", true).$n()),
		ztl.normalizeText("-1"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
