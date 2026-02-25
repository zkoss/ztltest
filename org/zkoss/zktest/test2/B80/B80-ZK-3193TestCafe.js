import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3193TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3193.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3193TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@bandbox").find(".z-bandbox-button")[0]));
	await ztl.waitResponse(t);
	let actionVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@listbox").height(),
	)();
	let actionVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@listbox").width(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_1_1 - 5 + "," + (actionVariable_cafe_0_0 - 5),
	);

	await t.click(
		Selector(() => jq("@listbox")[0]),
		{ offsetX: cafeCoord_1[0], offsetY: cafeCoord_1[1] },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("body")[0]));
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
});
