import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-414TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-414.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-414TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk(jq(".z-treerow:contains(something):eq(1)")).scrollIntoView();
	})();
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(something):eq(1)")).$n("open"),
		),
	);
	await ztl.waitResponse(t);
	await t.wait(2000);
	let verifyVariable_cafe_0_0 = await ztl.getScrollTop({
		locator: Selector(() => zk.Widget.$(jq("$groupTree")).$n()),
	});
	await t.expect(verifyVariable_cafe_0_0 > 200).ok();
});
