import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2929590TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2929590.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2929590TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let offsetLeft_cafe = await ClientFunction(
		() => jq("$win").offset().left,
	)();
	let offsetTop_cafe = await ClientFunction(() => jq("$win").offset().top)();
	await t.drag(
		Selector(() => jq("$win").find(".z-window-header-move")[0]),
		50,
		50,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$win").offset().left)(),
			),
		)
		.notEql(ztl.normalizeText(offsetLeft_cafe), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$win").offset().top)(),
			),
		)
		.notEql(ztl.normalizeText(offsetTop_cafe), "");
});
