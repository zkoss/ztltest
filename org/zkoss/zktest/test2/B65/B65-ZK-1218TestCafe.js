import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1218TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1218.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1218TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-doublebox")[0])).typeText(
		Selector(() => jq(".z-doublebox")[0]),
		ztl.normalizeText("1.224323423452352345345345634534634634"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox:eq(0)")[0])())
		.ok();
	await t.click(Selector(() => jq(".z-doublespinner-input")[0])).typeText(
		Selector(() => jq(".z-doublespinner-input")[0]),
		ztl.normalizeText("1.224323423452352345345345634534634634"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox:eq(1)")[0])())
		.ok();
});
