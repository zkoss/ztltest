import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2783TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2783.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2783TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).open();
	})();
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("26"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@comboitem:first").outerHeight())(),
		),
		ztl.normalizeText("2"),
	);
});
