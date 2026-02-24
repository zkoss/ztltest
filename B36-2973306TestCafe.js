import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2973306TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2973306.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2973306TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("android")) {
		console.log("This issue is ignored in current browser! (android)");
		return;
	}
	await t.click(Selector(() => zk.Widget.$(jq("$detail")).$n("icon")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Widget.$(jq("$detail")).$n("fake")).find(">td")
							.length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
});
