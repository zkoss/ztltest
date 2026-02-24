import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3286TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3286.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3286TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9")) {
		console.log("This issue is ignored in current browser! (ie9)");
		return;
	}
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => jq(".z-calendar-cell.z-calendar-weekday:eq(15)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-calendar-cell.z-calendar-weekday:eq(15)")[0]),
	);
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-datebox-input").val())(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
});
