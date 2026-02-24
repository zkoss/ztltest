import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3925TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3925.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3925TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq("@button")[0]))
		.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@panel").width())(),
			),
		)
		.eql(ztl.normalizeText("400"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@panel").height())(),
			),
		)
		.eql(ztl.normalizeText("300"));
});
