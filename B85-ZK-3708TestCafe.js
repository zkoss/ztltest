import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3708TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3708.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3708TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-splitlayout").eq(0).children().eq(1).width(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-splitlayout").eq(0).width(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-splitlayout").eq(1).children().eq(1).height(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-splitlayout").eq(1).height(),
				)(),
			),
		);
});
