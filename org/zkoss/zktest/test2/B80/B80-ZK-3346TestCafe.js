import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3346TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3346.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3346TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-label")[2]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-button")[2]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-textbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-div")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.ok();
	// Click a point that always exists on-screen and is outside the popup, to close it.
	await t.click(Selector(() => document.body), { offsetX: 5, offsetY: 5 });
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-popup:eq(0)").is(":visible"))(),
		)
		.notOk();
});
