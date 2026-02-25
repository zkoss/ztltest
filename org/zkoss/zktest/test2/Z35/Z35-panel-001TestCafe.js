import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z35-panel-001TestCafe`
	.page`http://localhost:8080/zktest/test2/Z35-panel-001.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("Z35-panel-001TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(ztl.normalizeText("0"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-panel-header").length)(),
			),
		);
	await t.click(Selector(() => jq("$btn1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-panel-header").length)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Panel Component"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-panel-header").text().replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-panelchildren").length)(),
			),
		);
	await t.click(Selector(() => jq("$btn2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-panel").hasClass(".z-panel-noborder"),
			)(),
		)
		.notOk();
	let w_cafe = await ClientFunction(() => jq(".z-panel").outerWidth())();
	await t.click(Selector(() => jq("$btn4")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-panel").outerWidth())(),
			),
		)
		.notEql(ztl.normalizeText(w_cafe), "");
});
