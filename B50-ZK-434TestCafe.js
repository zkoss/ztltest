import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-434TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-434.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-434TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-timebox-input").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("home");
	await ztl.waitResponse(t);
	await t.pressKey("delete");
	await ztl.waitResponse(t);
	await t.pressKey("delete");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-timebox-input").eq(0))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-timebox-input").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 1 2 1 2");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-timebox-input").eq(0).val(),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("M 12:12:12"),
			'it should appear "AM/PM" 12:12:12 in timebox',
		);
	if (
		await ClientFunction(
			() => jq(jq(".z-timebox-input").eq(0))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-timebox-input").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("ctrl+a");
	await ztl.waitResponse(t);
	await t.pressKey("delete");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-timebox-input").eq(0))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-timebox-input").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 1 2 1 2");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-timebox-input").eq(0).val(),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("M 12:12:12"),
			'it should appear "AM/PM" 12:12:12 in timebox',
		);
});
