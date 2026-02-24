import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B86-ZK-4100TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4100.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4100TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(jq("@datebox:eq(0) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@datebox:eq(0) > input")[0]),
		ztl.normalizeText("31.11.2018"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox:eq(0) > input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("31.11.2018"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-messagebox-error")[0] ||
					!!jq(".z-errorbox")[0] ||
					jq(".z-error")[0],
			)(),
		)
		.ok();
	await ClientFunction(() => {
		jq(jq("@datebox:eq(0) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox:eq(0) > input")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("@datebox:eq(0) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("@datebox:eq(1) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@datebox:eq(1) > input")[0]),
		ztl.normalizeText("31.11.2018"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox:eq(1) > input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("31.11.2018"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-messagebox-error")[0] ||
					!!jq(".z-errorbox")[0] ||
					jq(".z-error")[0],
			)(),
		)
		.ok();
	await ClientFunction(() => {
		jq(jq("@datebox:eq(1) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@datebox:eq(1) > input")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("@datebox:eq(1) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("@datebox:eq(2) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@datebox:eq(2) > input")[0]),
		ztl.normalizeText("31.11.2018"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox:eq(2) > input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("01.12.2018"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-messagebox-error")[0] ||
					!!jq(".z-errorbox")[0] ||
					jq(".z-error")[0],
			)(),
		)
		.notOk();
	await ClientFunction(() => {
		jq(jq("@datebox:eq(3) > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@datebox:eq(3) > input")[0]),
		ztl.normalizeText("31.11.2018"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@datebox:eq(3) > input").val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("31.11.2018"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-messagebox-error")[0] ||
					!!jq(".z-errorbox")[0] ||
					jq(".z-error")[0],
			)(),
		)
		.ok();
});
