import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F86-ZK-3963-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F86-ZK-3963-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/F86-ZK-3963.zul"/>`);
	await t.click(Selector(() => jq(".z-button:contains(setDisabled)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-organigram:eq(0) .z-orgnode:contains(item3)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(isSelected)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(setDisabled)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(setSelectable)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-organigram:eq(0) .z-orgnode:contains(item3)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(isSelected)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(setSelectable)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(appendChild)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-organigram:eq(0) .z-orgnode:contains(newItem)")[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-button:contains(removeChild)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-organigram:eq(0) .z-orgnode:contains(newItem)")[0],
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-button:contains(isOpen)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(setOpen)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(isOpen)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-button:contains(getVisibleItemCount())")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(isSelected)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(setSelected)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(isSelected)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-button:contains(getSelectedItem())")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("item3"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(getLevel)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(getParentItem)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("item1"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(isContainer)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(isEmpty)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
});
