import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2435TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2435.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2435TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-listitem").first().find(".z-listcell")[0]),
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@listbox")).$n("a").focus();
	})();
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("John"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("input").val())()),
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-listitem").first().find(".z-listcell")[0]),
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@listbox")).$n("a").focus();
	})();
	await t.pressKey("esc");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("input").val())()),
		);
});
