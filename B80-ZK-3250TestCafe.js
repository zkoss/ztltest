import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3250TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3250.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3250TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-listbox-body")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await ztl.doScroll({
		locator: Selector(() => jq(".z-listbox-body")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("after setItemsInvalid_"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("after setItemsInvalid_"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-listbox-body")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("after setItemsInvalid_"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
			"",
		);
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
});
