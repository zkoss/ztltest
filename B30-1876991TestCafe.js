import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1876991TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1876991.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1876991TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("myIntbox", true))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("myIntbox", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("1 0 0");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("myIntbox", true))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("myIntbox", true).$n()),
		ztl.normalizeText("-100"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
