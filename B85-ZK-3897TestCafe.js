import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3897TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3897.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3897TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:contains(Near Min)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox a.z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox .z-datebox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("left");
	await ztl.waitResponse(t);
	await t.pressKey("left");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox .z-datebox-input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1900/01/01 23:59:59"));
	await t.click(Selector(() => jq("@button:contains(Near Max)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox a.z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq("@datebox .z-datebox-input")[0]))
		.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox .z-datebox-input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2099/12/31 00:00:00"));
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:contains(Near Min)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox a.z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox .z-datebox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("left");
	await ztl.waitResponse(t);
	await t.pressKey("left");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox .z-datebox-input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1900/01/01 23:59:59"));
	await t.click(Selector(() => jq("@button:contains(Near Max)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox a.z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq("@datebox .z-datebox-input")[0]))
		.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox .z-datebox-input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2099/12/31 00:00:00"));
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:contains(Near Min)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox a.z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox .z-datebox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("left");
	await ztl.waitResponse(t);
	await t.pressKey("left");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox .z-datebox-input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1900/01/01 23:59:59"));
	await t.click(Selector(() => jq("@button:contains(Near Max)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox a.z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq("@datebox .z-datebox-input")[0]))
		.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox .z-datebox-input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2099/12/31 00:00:00"));
});
