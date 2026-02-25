import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3766TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3766.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3766TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$target").find("a")[0]));
	await ztl.waitResponse(t);
	let ppLeft_cafe = await ClientFunction(
		() => jq(".z-bandbox-popup.z-bandbox-open:visible").offset().left,
	)();
	let bbLeft_cafe = await ClientFunction(() => jq("$target").offset().left)();
	let delta_cafe = ppLeft_cafe - bbLeft_cafe;
	await t
		.expect(delta_cafe < -5)
		.ok("The popup should be positioned after_end, not after_start.");
});
