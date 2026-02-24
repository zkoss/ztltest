import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3773TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3773.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3773TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@groupbox @button").eq(0)[0])).wait(2000);
	await ztl.waitResponse(t);
	await t.wait(5000).click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let leftBtnOffsetRight_cafe_0 = await ClientFunction(
		() => jq(".z-messagebox-button").eq(0).offset().left,
	)();
	let leftBtnOffsetRight_cafe_1 = await ClientFunction(() =>
		jq(".z-messagebox-button").eq(0).outerWidth(false),
	)();
	let leftBtnOffsetRight_cafe =
		leftBtnOffsetRight_cafe_0 + leftBtnOffsetRight_cafe_1;
	let rightBtnOffsetLeft_cafe = await ClientFunction(
		() => jq(".z-messagebox-button").eq(1).offset().left,
	)();
	await t
		.expect(rightBtnOffsetLeft_cafe - leftBtnOffsetRight_cafe >= 3)
		.ok("The buttons must have some spaces");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-buttons").css("text-align"),
				)(),
			),
		)
		.eql(ztl.normalizeText("center"), "The buttons should be centered");
	await t.click(Selector(() => jq(".z-messagebox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@groupbox @button").eq(1)[0])).wait(2000);
	await ztl.waitResponse(t);
	await t.wait(5000).click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let leftBtnOffsetRight_cafe_0t = await ClientFunction(
		() => jq(".z-messagebox-button").eq(0).offset().left,
	)();
	let leftBtnOffsetRight_cafe_1t = await ClientFunction(() =>
		jq(".z-messagebox-button").eq(0).outerWidth(false),
	)();
	let leftBtnOffsetRight_cafet =
		leftBtnOffsetRight_cafe_0t + leftBtnOffsetRight_cafe_1t;
	let rightBtnOffsetLeft_cafet = await ClientFunction(
		() => jq(".z-messagebox-button").eq(1).offset().left,
	)();
	await t
		.expect(rightBtnOffsetLeft_cafet - leftBtnOffsetRight_cafet >= 3)
		.ok("The buttons must have some spaces");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-buttons").css("text-align"),
				)(),
			),
		)
		.eql(ztl.normalizeText("center"), "The buttons should be centered");
	await t.click(Selector(() => jq(".z-messagebox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@groupbox @button").eq(2)[0])).wait(2000);
	await ztl.waitResponse(t);
	await t.wait(5000).click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let leftBtnOffsetRight_cafe_0tt = await ClientFunction(
		() => jq(".z-messagebox-button").eq(0).offset().left,
	)();
	let leftBtnOffsetRight_cafe_1tt = await ClientFunction(() =>
		jq(".z-messagebox-button").eq(0).outerWidth(false),
	)();
	let leftBtnOffsetRight_cafett =
		leftBtnOffsetRight_cafe_0tt + leftBtnOffsetRight_cafe_1tt;
	let rightBtnOffsetLeft_cafett = await ClientFunction(
		() => jq(".z-messagebox-button").eq(1).offset().left,
	)();
	await t
		.expect(rightBtnOffsetLeft_cafett - leftBtnOffsetRight_cafett >= 3)
		.ok("The buttons must have some spaces");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-buttons").css("text-align"),
				)(),
			),
		)
		.eql(ztl.normalizeText("center"), "The buttons should be centered");
	await t.click(Selector(() => jq(".z-messagebox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$restore")[0])).wait(2000);
});
