import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1867370TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1867370.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1867370TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("mybutton", true).$n()));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("1"),
		ztl.normalizeText(await ClientFunction(() => jq(".z-row").length)()),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@paging").find(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("mybutton", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
	await t.click(Selector(() => jq("@paging").find(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
});
