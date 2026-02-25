import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1278TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1278.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1278TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:contains(A)")).$n("icon")),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:contains(B)")).$n("icon")),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("#zk_log").height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("#zk_log").scrollTop(),
	)();
	await t
		.expect(verifyVariable_cafe_1_1 <= verifyVariable_cafe_0_0)
		.ok("the log textbox should not appear the scrollbar");
});
