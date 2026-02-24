import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1031TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1031.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1031TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.click(Selector(() => jq(zk.Desktop._dt.$f("sbx", true))[0]))
		.click(
			Selector(
				() => jq(zk.Desktop._dt.$f("sbx", true)).find("option")[1],
			),
		);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("No exception");
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1", true).$n().innerHTML,
				)(),
			),
			"Select index in label 1 should be 1",
		);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2", true).$n().innerHTML,
				)(),
			),
			"Select index in label 2 should be 1",
		);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb3", true).$n().innerHTML,
				)(),
			),
			"Select index in label 3 should be 1",
		);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb4", true).$n().innerHTML,
				)(),
			),
			"Select index in label 4 should be 1",
		);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb5", true).$n().innerHTML,
				)(),
			),
			"Select index in label 5 should be 1",
		);
});
