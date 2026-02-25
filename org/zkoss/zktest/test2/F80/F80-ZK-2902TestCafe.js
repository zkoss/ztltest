import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F80-ZK-2902TestCafe`
	.page`http://localhost:8080/zktest/test2/F80-ZK-2902.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F80-ZK-2902TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	let li_cafe = await ClientFunction(() =>
		jq(".z-listcell-content").eq(4).text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(li_cafe)).eql(ztl.normalizeText("item3"));
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	li_cafe = await ClientFunction(() =>
		jq(".z-listcell-content").eq(8).text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(li_cafe)).eql(ztl.normalizeText("item4"));
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	li_cafe = await ClientFunction(() =>
		jq(".z-listcell-content").eq(14).text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(li_cafe)).eql(ztl.normalizeText("item4"));
	await t.click(Selector(() => jq("@button").eq(3)[0]));
	await ztl.waitResponse(t);
	li_cafe = await ClientFunction(() =>
		jq(".z-listcell-content").eq(19).text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(li_cafe)).eql(ztl.normalizeText("item5"));
	await t.click(Selector(() => jq("@button").eq(4)[0]));
	await ztl.waitResponse(t);
	li_cafe = await ClientFunction(() =>
		jq(".z-listcell-content").eq(27).text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(li_cafe)).eql(ztl.normalizeText("item6"));
	await t.click(Selector(() => jq("@button").eq(5)[0]));
	await ztl.waitResponse(t);
	li_cafe = await ClientFunction(() =>
		jq(".z-listcell-content").eq(34).text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(li_cafe)).eql(ztl.normalizeText("item7"));
});
