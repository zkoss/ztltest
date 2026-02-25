import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1535TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1535.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1535TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(jq(".z-datebox-input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(".z-datebox-input")[0]),
		ztl.normalizeText("Mar 1, 2013"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-datebox-popup .z-calendar-text:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Mar"), "should see Mar");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-datebox-popup .z-calendar-text:eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2013"), "should see 2013");
	await t
		.expect(ztl.normalizeText("6"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(".z-datebox-popup").find(".z-calendar tbody tr")
							.length,
				)(),
			),
			"should see 6 weeks showed.",
		);
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-text").last()[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-text").last()[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-text").last()[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-text").last().text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("1990 - 2099"), "should see 1990 - 2099");
	await t.click(Selector(() => jq(".z-calendar-cell[data-value=2010]")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-cell[data-value=2013]")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-cell[data-value=2]")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-text").last().text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2013"), "should see 2013");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-text")
						.last()
						.prev()
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Mar"), "should see Mar");
	await t.wait(10000);
	await t
		.expect(ztl.normalizeText("6"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-calendar").last().find("tbody tr").length,
				)(),
			),
			"should see 6 weeks showed.",
		);
});
