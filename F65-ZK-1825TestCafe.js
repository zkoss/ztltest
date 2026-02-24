import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F65-ZK-1825TestCafe`
	.page`http://localhost:8080/zktest/test2/F65-ZK-1825.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F65-ZK-1825TestCafe", async (t) => {
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
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(
						".z-messagebox-window .z-label:contains(Sun Oct 20)",
					)[0],
			)(),
		)
		.ok("It shouldn't be reset to today");
});
