import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2997034TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2997034.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2997034TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("div", true).$n()),
		scrollType: "vertical",
		noBody: true,
		dist: await ClientFunction(
			() => jq(zk.Desktop._dt.$f("li1", true)).position().top,
		)(),
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let curScrollTop_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Desktop._dt.$f("div", true).$n()),
	});
	curScrollTop_cafe = curScrollTop_cafe - 10;
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("div", true).$n()),
		scrollType: "vertical",
		noBody: true,
		dist: curScrollTop_cafe,
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("li1", true).$n("cm")));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(curScrollTop_cafe),
		ztl.normalizeText(
			await ztl.getScrollTop({
				locator: Selector(() => zk.Desktop._dt.$f("div", true).$n()),
			}),
		),
		ztl.normalizeText("10"),
	);
});
