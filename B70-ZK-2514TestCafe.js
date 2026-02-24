import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2514TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2514.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2514TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.drag(
		Selector(() => jq(".z-splitter-horizontal")[0]),
		-203,
		0,
		{ offsetX: 3, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	let oldWidth_cafe = await ClientFunction(() => jq(".z-vbox").width())();
	await t.drag(
		Selector(() => jq(".z-splitter-horizontal")[0]),
		227,
		0,
		{ offsetX: 3, offsetY: 3 },
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-vbox").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0 - oldWidth_cafe > 0).ok();
	await ztl.waitResponse(t);
	let oldHeight_cafe = await ClientFunction(() => jq(".z-vbox").height())();
	await t.drag(
		Selector(() => jq(".z-splitter-vertical")[0]),
		0,
		-103,
		{ offsetX: 3, offsetY: 3 },
	);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-vbox").height(),
	)();
	await t.expect(verifyVariable_cafe_1_1 - oldHeight_cafe == 0).ok();
});
