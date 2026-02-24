import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3011319TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3011319.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3011319TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("db", true).$n("pp")).find(
					".z-calendar-left",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("db", true).$n("pp"))
							.find(".z-calendar-title")
							.find(".z-calendar-text")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Apr"), "the title should be April");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("db", true).$n("pp")).find(
							".z-calendar-selected",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("30"),
			"the 30th day of April should be selected",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-text")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-month").find("td")[1]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("db", true).$n("pp"))
							.find(".z-calendar-title")
							.find(".z-calendar-text")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Feb"), "the title should be Feburary");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("db", true).$n("pp")).find(
							".z-calendar-selected",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("28"),
			"the 28th day of Feburary should be selected",
		);
});
