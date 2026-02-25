import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2026TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2026.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2026TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-datebox")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(".z-calendar:eq(0)").find(
					".z-calendar-title .z-calendar-text:eq(1)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(".z-calendar:eq(0)").find(
					".z-calendar-title .z-calendar-text:eq(0)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(".z-calendar:eq(0)").find(
					'.z-calendar-body td[data-value="2010"]',
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(".z-calendar:eq(0)").find(
					".z-calendar-body td:contains(2013)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-calendar:eq(0)").find(".z-calendar-body td:eq(9)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(".z-calendar:eq(0)").find(
					".z-calendar-body td:contains(20)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-datebox")).$n("real").value,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("2026"),
			"the year should not changes to the current year.",
		);
});
