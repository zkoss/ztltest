import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-2598TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2598.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2598TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button").eq(0)[0]));
	await ztl.waitResponse(t);
	let result_cafe = await ClientFunction(() =>
		jq(".z-messagebox-window .z-label").text().replace(/\s/g, " "),
	)();
	await t.click(Selector(() => jq(".z-messagebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-button")[0])())
		.ok();
	await t
		.expect(ztl.normalizeText(result_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-messagebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-button")[0])())
		.ok();
	await t
		.expect(ztl.normalizeText(result_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-messagebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-button")[0])())
		.ok();
	await t
		.expect(ztl.normalizeText(result_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-messagebox-button")[0]));
	await ztl.waitResponse(t);
});
