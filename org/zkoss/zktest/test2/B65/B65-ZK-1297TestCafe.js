import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1297TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1297.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1297TestCafe", async (t) => {
	await ztl.initTest(t);
	let height_cafe = await ClientFunction(() => jq("@listbox").height())();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let newHeight_cafe = await ClientFunction(() => jq("@listbox").height())();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(height_cafe),
		ztl.normalizeText(newHeight_cafe),
		ztl.normalizeText("10"),
	);
});
