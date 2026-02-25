import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2084TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2084.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2084TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-doublespinner").eq(0)).$n("btn-up")),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-doublespinner").eq(0)).$n("btn-down"),
		),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should see 0.0");
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-doublespinner").eq(1)).$n("btn-up")),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-doublespinner").eq(1)).$n("btn-down"),
		),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should see 0.0");
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-doublespinner").eq(2)).$n("btn-up")),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-doublespinner").eq(2)).$n("btn-down"),
		),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("should see 0.00");
});
