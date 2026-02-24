import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2515562TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2515562.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2515562TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-datebox")).$n("btn"))[0]),
	);
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("yellow"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-calendar-text").css("color"),
					)(),
				),
			),
		)
		.ok();
});
