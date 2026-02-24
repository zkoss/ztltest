import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3143TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3143.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3143TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.click(
			Selector(() => jq(".z-listitem-checkbox")[0]),
			{ modifiers: { shift: true } },
		)
		.click(
			Selector(() => jq(".z-listitem-checkbox")[5]),
			{ modifiers: { shift: true } },
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.ie && zk.ie == 8
						? document.selection.createRange().text
						: window.getSelection().toString(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});
