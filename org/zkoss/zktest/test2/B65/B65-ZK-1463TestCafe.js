import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1463TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1463.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1463TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:contains(1)")[0]));
	await ztl.waitResponse(t);
	let disabled_cafe = await ClientFunction(() =>
		jq(jq("@button:contains(Save)")).attr("disabled"),
	)();
	await t.click(Selector(() => jq("@button:contains(Save)")[0]));
	await ztl.waitResponse(t);
	let clickWork_cafe = await ClientFunction(() =>
		jq("@window").is(":visible"),
	)();
	await t.expect(disabled_cafe).notOk("should be enabled");
	await t.expect(clickWork_cafe).ok("should be click-able");
});
