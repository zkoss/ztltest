import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2104921TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2104921.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2104921TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(zk.Widget.$(jq("$e")).$n("btn"))[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(zk.Widget.$(jq("$w")).$n("btn"))[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(zk.Widget.$(jq("$e")).$n("colled"))[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@east").eq(1).is(":visible"))())
		.ok("The east zone should be visible");
	await t.click(Selector(() => jq(zk.Widget.$(jq("$w")).$n("colled"))[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-east").eq(1).is(":visible"))(),
		)
		.notOk("The east zone should be collapsed");
});
