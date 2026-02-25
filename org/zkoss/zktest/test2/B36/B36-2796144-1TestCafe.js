import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2796144-1TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2796144.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2796144-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("returnDate", true).$n("real").focus();
	})();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("returnDate", true).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq("@timebox").find("input")[0]))
		.pressKey("end down");
	let time_cafe = await ClientFunction(() =>
		jq("@timebox").find("input").val(),
	)();
	await t.click(Selector(() => jq("td.z-calendar-selected")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("dateValue2", true).getValue(),
				)(),
			),
		)
		.contains(ztl.normalizeText(time_cafe), "");
});
