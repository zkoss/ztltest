import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2956449TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2956449.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2956449TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq("$tb").focus();
	})();
	await t.pressKey("up");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$l").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("38"));
	await ClientFunction(() => {
		jq("$tb").focus();
	})();
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$l").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("40"));
});
