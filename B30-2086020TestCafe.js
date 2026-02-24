import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2086020TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-2086020.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-2086020TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.click(Selector(() => jq(zk.Widget.$("@combobox").$n("real"))[0]))
		.typeText(
			Selector(() => jq(zk.Widget.$("@combobox").$n("real"))[0]),
			ztl.normalizeText("aa"),
		);
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$copy").val())()),
		)
		.eql(ztl.normalizeText("aa"));
});
