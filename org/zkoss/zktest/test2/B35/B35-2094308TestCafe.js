import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2094308TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2094308.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2094308TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("top", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("top", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("2 0 0");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("left", true))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("left", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("3 0 0");
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("save", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
