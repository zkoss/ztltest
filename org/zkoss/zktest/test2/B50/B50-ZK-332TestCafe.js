import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-332TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-332.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-332TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(zk.Desktop._dt.$f("tr", true).$n("open"))[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("tree", true).$n("rows")).find(
							".z-treerow",
						).length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(
		Selector(() => jq(zk.Desktop._dt.$f("tr", true).$n("open"))[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("tree", true).$n("rows")).find(
							".z-treerow",
						)[2].style.display,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("tree", true).$n("rows")).find(
							".z-treerow",
						)[3].style.display,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});
