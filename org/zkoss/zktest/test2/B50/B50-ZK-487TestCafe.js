import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-487TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-487.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-487TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(
			() => jq(zk.Desktop._dt.$f("gb1", true)).find(".z-caption")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(zk.Desktop._dt.$f("gb2", true)).find(".z-caption")[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("200"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("gb1", true)).outerHeight(),
				)(),
			),
			"Height should be 200",
		);
	await t
		.expect(ztl.normalizeText("200"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("gb2", true)).outerHeight(),
				)(),
			),
			"Height should be 200",
		);
});
