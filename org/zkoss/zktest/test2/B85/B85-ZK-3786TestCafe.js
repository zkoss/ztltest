import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3786TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3786.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3786TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9,ie10")) {
		console.log("This issue is ignored in current browser! (ie9,ie10)");
		return;
	}
	await t.click(Selector(() => jq('@button[label="add under bottom"]')[0]));
	await ztl.waitResponse(t);
	let scrollTop_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Desktop._dt.$f("tree", true).$n()),
	});
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("215"),
		ztl.normalizeText(scrollTop_cafe),
		ztl.normalizeText("10"),
	);
	await t.click(Selector(() => jq('@button[label="add under bottom"]')[0]));
	await ztl.waitResponse(t);
	scrollTop_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Desktop._dt.$f("tree", true).$n()),
	});
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("260"),
		ztl.normalizeText(scrollTop_cafe),
		ztl.normalizeText("10"),
	);
	await t.click(Selector(() => jq('@button[label="add upon top"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="add upon top"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Desktop._dt.$f("tree", true).$n(),
					),
				}),
			),
		)
		.eql(ztl.normalizeText("0"));
});
