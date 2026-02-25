import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-306TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-306.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-306TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("tree", true).$n("body")).find(
					".z-treerow",
				)[1],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("btn", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					getAnnotCnt(zk.Desktop._dt.$f("tb", true).$n()),
				)(),
			),
		);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("tree", true).$n("body")).find(
					".z-treerow",
				)[3],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("btn", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					getAnnotCnt(zk.Desktop._dt.$f("tb", true).$n()),
				)(),
			),
		);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("tree2", true).$n("body")).find(
					".z-treerow",
				)[1],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("tree2", true).$n("body")).find(
					".z-treerow",
				)[2],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("tree2", true).$n("body")).find(
					".z-treerow",
				)[3],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("btn2", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("4"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					getAnnotCnt(zk.Desktop._dt.$f("tb2", true).$n()),
				)(),
			),
		);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("tree2", true).$n("body")).find(
					".z-treerow",
				)[2],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("btn2", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("3"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					getAnnotCnt(zk.Desktop._dt.$f("tb2", true).$n()),
				)(),
			),
		);
});
