import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2307TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2307.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2307TestCafe", async (t) => {
	await ztl.initTest(t);
	let originW_cafe = await ClientFunction(() => document.body.offsetWidth)();
	let originH_cafe = await ClientFunction(() => document.body.offsetHeight)();
	await t.resizeWindow(500, originH_cafe);
	await t.wait(500);
	let h5l_cafe = await ClientFunction(() => jq("$h5").offset().left)();
	let i5l_cafe = await ClientFunction(() => jq("$i5").offset().left)();
	await t
		.expect(h5l_cafe == i5l_cafe)
		.ok("list head and cell must align to same vertial line.");
	await t.resizeWindow(originW_cafe, originH_cafe);
});
