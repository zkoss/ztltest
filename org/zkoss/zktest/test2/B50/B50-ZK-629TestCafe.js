import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-629TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-629.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-629TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db1", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("0,"),
			'You should see the values in each input element "0,5" or "0,00...5", not "5".',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db2", true).$n("real").value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("0,"),
			'You should see the values in each input element "0,5" or "0,00...5", not "5".',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db3", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("0,"),
			'You should see the values in each input element "0,5" or "0,00...5", not "5".',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db4", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("0,"),
			'You should see the values in each input element "0,5" or "0,00...5", not "5".',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db5", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("0,"),
			'You should see the values in each input element "0,5" or "0,00...5", not "5".',
		);
	await t.wait(1000).click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
});
