import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2709TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2709.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2709TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@timebox input")[0]));
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq("@timebox input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("@timebox input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("left left left left left left left left 1 1 enter");
	await ztl.waitResponse(t);
	let dateboxInput_cafe = await ClientFunction(() =>
		jq(".z-datebox-input").val(),
	)();
	await t
		.expect(ztl.normalizeText(dateboxInput_cafe))
		.contains(ztl.normalizeText("11"), "");
});
