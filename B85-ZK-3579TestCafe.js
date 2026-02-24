import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3579TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3579.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3579TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("400"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@combobutton:eq(0) .z-combobutton-content").outerWidth(),
			)(),
		),
		ztl.normalizeText("4"),
	);
});
