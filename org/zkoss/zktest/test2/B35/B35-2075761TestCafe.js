import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075761TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2075761.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2075761TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-west")).$n("split")).is(":visible"),
			)(),
		)
		.notOk("The west splitter should not be visible");
	let noSplitterWidth_cafe = await ClientFunction(() =>
		jq(".z-center").width(),
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let withSplitterWidth_cafe = await ClientFunction(() =>
		jq(".z-center").width(),
	)();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-west")).$n("split")).is(":visible"),
			)(),
		)
		.ok("The west splitter should be visible");
	await t
		.expect(noSplitterWidth_cafe - withSplitterWidth_cafe == 8)
		.ok(
			"The width of the center zone should be smaller than without the splitter",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-west")).$n("split")).is(":visible"),
			)(),
		)
		.notOk("The west splitter should not be visible");
});
