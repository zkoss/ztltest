import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2788618TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2788618TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			Please selet today, and then it should not appear a warning box.
			<datebox constraint="no future" id="db"/>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("td.z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
});
