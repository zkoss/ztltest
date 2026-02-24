import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2635TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2635.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2635TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.hover(Selector(() => jq(".z-nav a")[0]));
	await ztl.waitResponse(t);
	let left_cafe = await ClientFunction(() =>
		jq(".z-nav-popup").css("left"),
	)();
	await t
		.hover(Selector(() => jq(".z-navitem a").first()[0]))
		.click(Selector(() => jq(".z-navitem a").first()[0]))
		.hover(Selector(() => jq(".z-navitem a").first()[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(left_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-nav-popup").css("left"))(),
			),
		);
});
