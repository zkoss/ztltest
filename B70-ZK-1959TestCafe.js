import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-1959TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-1959.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-1959TestCafe", async (t) => {
	await ztl.initTest(t);
	let h_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-tabbox")).$n("left")).height(),
	)();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-tabbox")).$n("left")).height(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(h_cafe),
			"the height of arrow should not change",
		);
});
