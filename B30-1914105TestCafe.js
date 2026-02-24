import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1914105TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1914105.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1914105TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("tb", true).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("tb", true).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 : 0 0 : 0 0");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("tb", true).$n("real")).val(),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("12:00:00"),
			"value should start with 12:00:00",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("ck1", true).$n("real")));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("tb", true).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("tb", true).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 : 0 0 : 0 1");
	await t
		.expect(ztl.normalizeText("12:00:00"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("tb", true).$n("real")).val(),
				)(),
			),
			"value should be 12:00:00",
		);
	await t.click(Selector(() => zk.Widget.$(jq(".z-timebox")).$n("btn-up")));
	let value_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tb", true).$n("real")).val(),
	)();
	await t
		.expect(ztl.normalizeText("12:00:00"))
		.notEql(ztl.normalizeText(value_cafe), "value should not be 12:00:00");
	await t.click(Selector(() => zk.Desktop._dt.$f("ck2", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-timebox")).$n("btn-up")));
	await t
		.expect(ztl.normalizeText(value_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("tb", true).$n("real")).val(),
				)(),
			),
			"value should be " + value_cafe,
		);
});
