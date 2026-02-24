import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3500TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3500.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3500TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-x-item").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(Selector(() => jq(".z-chosenbox")[0]));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-chosenbox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-chosenbox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("a enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-chosenbox-item").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
});
