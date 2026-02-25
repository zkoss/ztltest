//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1324TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1324.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1324TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-bandbox")).$n("real")).is(":focus"),
			)(),
		)
		.ok("Bandbox input field should have focus");
	await t.click(Selector(() => jq(".z-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-button:eq(0)")).is(":focus"),
			)(),
		)
		.ok("Button1 should have focus");
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).is(":visible"),
			)(),
		)
		.notOk("Click outside the popup to close the bandbox");
	await t.click(Selector(() => zk.Widget.$(jq(".z-bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).is(":visible"),
			)(),
		)
		.ok("Click on the bandbox button to open the popup again.");
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-bandbox")).$n("real")).is(":focus"),
			)(),
		)
		.ok("Bandbox input field should have focus");
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-button:eq(0)")).is(":focus"),
			)(),
		)
		.notOk("Button1 should not have focus");
});
