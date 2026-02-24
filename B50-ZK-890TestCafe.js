import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-890TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-890.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-890TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff,safari,edge_legacy,ie11,ie10")) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,edge_legacy,ie11,ie10)",
		);
		return;
	}
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-column").eq(0).is(":visible"),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-column").eq(1).is(":visible"),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-column").eq(2).is(":visible"),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
});
