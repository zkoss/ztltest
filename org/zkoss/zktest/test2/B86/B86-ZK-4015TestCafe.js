import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4015TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4015.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4015TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		window.scroll(0, 10000);
	})();
	await t.click(Selector(() => zk.Widget.$(jq("@bandbox:last")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@bandpopup:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => jq("@label:contains(*):last")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@bandpopup:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
});
