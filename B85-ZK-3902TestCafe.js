import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3902TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3902.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3902TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let popupTop_cafe = await ClientFunction(() => jq("@popup").offset().top)();
	let liTop_cafe = await ClientFunction(() => jq("@listitem").offset().top)();
	await t
		.expect(popupTop_cafe > liTop_cafe)
		.ok("The popup offsetTop is wrong.");
});
