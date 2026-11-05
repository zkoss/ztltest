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
	const leftEdge = { left: (el) => el.getBoundingClientRect().left };
	const header = Selector(() => jq("$h5")[0]).addCustomDOMProperties(
		leftEdge,
	);
	const cell = Selector(() => jq("$i5")[0]).addCustomDOMProperties(leftEdge);
	const cellLeft = await cell.left;
	await t
		.expect(header.left)
		.within(
			cellLeft - 0.5,
			cellLeft + 0.5,
			"the list head and its cell should start on the same vertical line",
		);
	await t.resizeWindow(originW_cafe, originH_cafe);
});
