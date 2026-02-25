import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2261249TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2261249.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2261249TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.hover(Selector(() => jq("@column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-column")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem:visible").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq("@column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-column")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem:visible").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq("@column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-column")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem:visible").eq(2)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk();
});
