import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2709-1TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2709-1.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2709-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq("@div")[0]),
		{ offsetX: 50, offsetY: 30 },
	);
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("input")[0]),
		ztl.normalizeText("selenium is really suck!!!!!!"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("it works"), "");
});
