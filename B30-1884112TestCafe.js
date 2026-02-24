import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1884112TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1884112.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1884112TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(Group0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(host-0)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-label")[3]));
	await t
		.expect(
			await ClientFunction(
				() => jq(".z-label:contains(p1000_10000_)")[0] != null,
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-button")[1]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => !!jq(".z-label:contains(p-0_0)")[0])(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-button")[2]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => !!jq(".z-label:contains(AAAAA)")[0])(),
		)
		.ok();
});
