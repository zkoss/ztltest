import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2929193TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2929193.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2929193TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("db", true).$n("pp")).find(
					".z-calendar-weekday",
				)[10],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db", true).$n("pp").style.display,
				)(),
			),
		)
		.eql(ztl.normalizeText("none"), "The Calendar should close");
});
