import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F86-ZK-4023TestCafe`
	.page`http://localhost:8080/zktest/test2/F86-ZK-4023.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F86-ZK-4023TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(jq("$d1 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("$d1 > input")[0]),
		ztl.normalizeText("Jan 0, 2018"),
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
		.eql(ztl.normalizeText("Dec 31, 2017"));
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
		jq(jq("$d1 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("$d1 > input")[0]),
		ztl.normalizeText("Feb 30, 2018"),
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
		.eql(ztl.normalizeText("Mar 2, 2018"));
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
		jq(jq("$d1 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("$d1 > input")[0]),
		ztl.normalizeText("Dec 20, 2018"),
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
		.eql(ztl.normalizeText("Dec 20, 2018"));
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
		jq(jq("$d2 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("$d2 > input")[0]),
		ztl.normalizeText("Jan 0, 2018"),
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
		.eql(ztl.normalizeText("Jan 0, 2018"));
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
		jq(jq("$d2 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$d2 > input")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("$d2 > input"))[0].value = "";
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
		ztl.normalizeText("Feb 30, 2018"),
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
		.eql(ztl.normalizeText("Feb 30, 2018"));
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
		jq(jq("$d2 > input"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$d2 > input")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("$d2 > input"))[0].value = "";
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
		ztl.normalizeText("Dec 20, 2018"),
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
		.eql(ztl.normalizeText("Dec 20, 2018"));
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
});
