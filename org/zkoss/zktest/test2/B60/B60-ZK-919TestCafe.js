import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-919TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-919.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-919TestCafe", async (t) => {
	await ztl.initTest(t);
	let datelongfmt0_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-datebox:eq(0)")).$n("real")).val(),
	)();
	let datelongfmt1_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-datebox:eq(1)")).$n("real")).val(),
	)();
	let datelongfmt2_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-datebox:eq(2)")).$n("real")).val(),
	)();
	let datelongfmt3_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-datebox:eq(3)")).$n("real")).val(),
	)();
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-datebox:eq(0)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-calendar:eq(0) .z-calendar-cell:contains(14)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-datebox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-calendar:eq(1) .z-calendar-cell:contains(14)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-datebox:eq(2)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-calendar:eq(2) .z-calendar-cell:contains(14)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-datebox:eq(3)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-calendar:eq(3) .z-calendar-cell:contains(14)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("should not see any error message.");
});
