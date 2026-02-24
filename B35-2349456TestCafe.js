import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2349456TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2349456.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2349456TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-listitem:contains(option 0)")[0]));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("list", true).$n("a").focus();
	})();
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.pressKey("down")
		.pressKey("down")
		.pressKey("down")
		.pressKey("up")
		.pressKey("up");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option 2"),
			"The selected item should be 'option 2'",
		);
});
