import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2795TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2795.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2795TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@a")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@popup")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@textbox")[0]),
		{ offsetX: 5, offsetY: 5 },
	);
	if (
		await ClientFunction(
			() => jq(jq("@textbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("@textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$testLabel").text().replace(/\s/g, " "),
				)(),
			),
		)
		.notEql(ztl.normalizeText("3. focus here and change value"), "");
});
