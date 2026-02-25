import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2129TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2129.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2129TestCafe", async (t) => {
	await ztl.initTest(t);
	let h_cafe = await ClientFunction(() => jq(".z-tree").height())();
	await ClientFunction(() => {
		jq(
			zk.Widget.$(jq(jq(".z-tree")).find(".z-frozen")).$n("scrollX"),
		)[0].scrollLeft = "200.0";
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-tree").height(),
	)();
	await t
		.expect(h_cafe == verifyVariable_cafe_0_0)
		.ok("height of the tree won't be changed");
});
