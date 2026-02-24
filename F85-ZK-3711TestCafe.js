import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F85-ZK-3711TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3711.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3711TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9")) {
		console.log("This issue is ignored in current browser! (ie9)");
		return;
	}
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(7)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		window.history.back();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@tabbox")).getSelectedIndex(),
				)(),
			),
		);
	await ClientFunction(() => {
		window.history.forward();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@tabbox")).getSelectedIndex(),
				)(),
			),
		);
});
