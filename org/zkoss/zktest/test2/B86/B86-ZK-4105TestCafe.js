import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4105TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4105.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4105TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() => jq(jq("@combobox input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("@combobox input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("- a b c").pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("(empty)"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("@combobox input").focus();
	})();
	await t.pressKey("left").pressKey("left").pressKey("left").pressKey("left");
	await ztl.waitResponse(t);
	await t.pressKey("delete").pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.notEql(ztl.normalizeText("(empty)"), "");
});
