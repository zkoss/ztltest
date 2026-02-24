import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1842TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1842.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1842TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button:contains(Open)")[0]));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-listbox")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox:last")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-menuitem")).$n("a")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Open)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-listitem:contains(a)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-listitem").length,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => !!jq(".z-listitem:contains(l)")[0],
	)();
	await t
		.expect(
			verifyVariable_cafe_1_1 == 2 &&
				verifyVariable_cafe_0_0 &&
				verifyVariable_cafe_2_2,
		)
		.ok("You should see 'l' and 'a' item only.");
});
