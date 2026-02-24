import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3914TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3914.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3914TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-grid-emptybody").width())(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-grid-emptybody").find("td").width(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-listbox-emptybody").width())(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-listbox-emptybody").find("td").width(),
			)(),
		),
		ztl.normalizeText("2"),
	);
});
