import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1876252TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1876252.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1876252TestCafe", async (t) => {
	await ztl.initTest(t);
	let rowHeight_cafe = await ClientFunction(() =>
		jq(".z-listitem").height(),
	)();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listitem:eq(1)").height())(),
			),
		)
		.eql(ztl.normalizeText(rowHeight_cafe));
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(rowHeight_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-listbox:eq(0)").height())(),
		),
		ztl.normalizeText("2"),
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-listbox:eq(1)").height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-listbox:eq(1)").height(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(rowHeight_cafe * 2),
		ztl.normalizeText(verifyVariable_cafe_1_1),
		ztl.normalizeText("2"),
	);
});
