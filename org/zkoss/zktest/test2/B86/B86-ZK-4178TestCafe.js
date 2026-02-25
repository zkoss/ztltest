import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4178TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4178.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4178TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(jq("$d1 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("$d1 > input")[0]),
		ztl.normalizeText("Aug 32, 2018"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$d1 > input").val())(),
			),
		)
		.eql(ztl.normalizeText("Aug 32, 2018"));
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
		jq(jq("$d1 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$d1 > input")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("$d1 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("$d2 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("$d2 > input")[0]),
		ztl.normalizeText("Aug 32, 2018"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$d2 > input").val())(),
			),
		)
		.eql(ztl.normalizeText("Aug 32, 2018"));
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
