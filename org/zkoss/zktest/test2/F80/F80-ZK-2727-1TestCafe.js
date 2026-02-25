import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F80-ZK-2727-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F80-ZK-2727-1TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("desktop")) {
		console.log("This issue is ignored in current browser! (desktop)");
		return;
	}
	await ztl.runZscript(t, `<include src="/test2/F80-ZK-2727.zul"/>`);
	let count_cafe = await ClientFunction(() => jq("@window").length)();
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		-200,
		0,
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("@window").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 > count_cafe).ok();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	count_cafe = await ClientFunction(() => jq("@window").length)();
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@scrollview")[0]),
		0,
		-200,
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("@window").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 > count_cafe).ok();
});
