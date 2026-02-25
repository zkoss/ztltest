import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-380TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-380.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-380TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("i1", true).$n("cm").style.visibility,
				)(),
			),
		)
		.notEql(ztl.normalizeText("hidden"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("i2", true).$n("cm").style.visibility,
				)(),
			),
		)
		.eql(ztl.normalizeText("hidden"));
	await t.click(Selector(() => zk.Desktop._dt.$f("i1", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("i2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("l1", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("l2", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
});
