import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1617TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1617.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1617TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button:contains(Rename)")[0]));
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(".z-panel-header")[0]),
		100,
		100,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-panel-header").offset().top,
				)(),
			),
		)
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$pos").text().replace(/\s/g, " "),
				)(),
			),
			"it should be able to drag and drop.",
		);
});
