import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1213TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1213.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1213TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("ty")));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("tyd")));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq('.z-calendar-cell[data-value="2010"]')[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq(".z-calendar-cell:contains(2012)")[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq(".z-calendar-cell:contains(Dec)")[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq(".z-calendar-cell:contains(16)")[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")));
	await ztl.waitResponse(t);
	await t.wait(500);
	await t
		.expect(ztl.normalizeText("Jan 2013"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-title").text().replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("16"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-weekday.z-calendar-selected")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("ty")));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("tyd")));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq('.z-calendar-cell[data-value="2010"]')[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq(".z-calendar-cell:contains(2012)")[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq(".z-calendar-cell:contains(Jan)")[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq(".z-calendar-cell:contains(31)")[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")));
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(ztl.normalizeText("Feb 2012"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-title").text().replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("29"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-calendar-weekday.z-calendar-selected")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
