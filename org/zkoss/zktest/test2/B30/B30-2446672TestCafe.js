import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2446672TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2446672TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			Please click on the image, you should not see any dialog.
			<toolbarbutton id="tbb" disabled="true" image="/test2/img/defender.gif"
							onClick=\'alert("Defender")\' />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("tbb", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.notOk();
});
