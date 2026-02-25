import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2787876TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2787876TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			Please type the word \'-\' and then focus out the box, you should see a warning box.
			<textbox id="txt_test" constraint="/[a-z\\\\]*/, server"></textbox>
			</zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("txt_test", true))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("txt_test", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("-");
	await t.pressKey("tab");
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
