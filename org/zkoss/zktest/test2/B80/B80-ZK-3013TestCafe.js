import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3013TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3013.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3013TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@combobox").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => zk.Widget.$(jq("@combobox").eq(0)).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("#zk_log").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(Selector(() => zk.Widget.$(jq("@combobox").eq(1)).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("#zk_log").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
});
