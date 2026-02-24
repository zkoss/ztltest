import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3928TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3928.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3928TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:contains(Open item-0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:contains(Select item-0-0-1)")[0]));
	await ztl.waitResponse(t);
	let scrollTop_cafe = await ClientFunction(() =>
		jq("@tree .z-tree-body").scrollTop(),
	)();
	await t
		.expect(ztl.normalizeText(scrollTop_cafe))
		.eql(
			ztl.normalizeText("0"),
			"The scroll position changes unnecessarily",
		);
});
