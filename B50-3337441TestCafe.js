import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3337441TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3337441.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3337441TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,safari,edge_legacy,ie11,ie10,ie9")) {
		console.log(
			"This issue is ignored in current browser! (chrome,safari,edge_legacy,ie11,ie10,ie9)",
		);
		return;
	}
	await t.click(Selector(() => jq(".z-listitem")[1]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem")[1]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-listitem")[3]),
		{ modifiers: { shift: true } },
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listitem-selected").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
});
