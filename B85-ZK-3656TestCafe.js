import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3656TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3656.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3656TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-listheader-checkable:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-listheader-checkable:eq(0)").hasClass(
					"z-listheader-checked",
				),
			)(),
		)
		.ok("The header checkbox status is wrong. (It should be checked)");
	let rowHeight_cafe = await ClientFunction(() =>
		jq(".z-listitem").outerHeight(),
	)();
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox .z-listbox-body")[0]),
		scrollType: "vertical",
		dist: rowHeight_cafe * 17,
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-listitem-checkbox > i").eq(20).is(":visible"),
			)(),
		)
		.ok("The 20th checkbox status is wrong. (It should be checked)");
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox .z-listbox-body")[0]),
		scrollType: "vertical",
		dist: rowHeight_cafe * 40,
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-listitem-checkbox > i").eq(44).is(":visible"),
			)(),
		)
		.ok("The 44th checkbox status is wrong. (It should be checked)");
});
