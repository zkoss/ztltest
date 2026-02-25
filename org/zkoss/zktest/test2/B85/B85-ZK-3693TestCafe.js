import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3693TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3693.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3693TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("$lb")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("$gr")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$lb").find(".z-listitem").last()[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$gr").find(".z-row").last()[0]));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("$lb_m")[0]),
		scrollType: "vertical",
		percent: "50.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("$gr_m")[0]),
		scrollType: "vertical",
		percent: "50.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("$lb_m")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("$gr_m")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$lb_m").find(".z-listitem").last()[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$gr_m").find(".z-row").last()[0]));
	await ztl.waitResponse(t);
});
