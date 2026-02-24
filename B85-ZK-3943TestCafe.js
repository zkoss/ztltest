import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3943TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3943.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3943TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let popRightEdge_cafe_0 = await ClientFunction(() =>
		jq("$mypop").outerWidth(),
	)();
	let popRightEdge_cafe_1 = await ClientFunction(
		() => jq("$mypop").offset().left,
	)();
	let popRightEdge_cafe = popRightEdge_cafe_1 + popRightEdge_cafe_0;
	let btnRightEdge_cafe_2 = await ClientFunction(() =>
		jq("@button:eq(0)").outerWidth(),
	)();
	let btnRightEdge_cafe_3 = await ClientFunction(
		() => jq("@button:eq(0)").offset().left,
	)();
	let btnRightEdge_cafe = btnRightEdge_cafe_3 + btnRightEdge_cafe_2;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(popRightEdge_cafe),
		ztl.normalizeText(btnRightEdge_cafe),
		ztl.normalizeText("2"),
	);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	let popRightEdge_cafe_0t = await ClientFunction(() =>
		jq("$mypop").outerWidth(),
	)();
	let popRightEdge_cafe_1t = await ClientFunction(
		() => jq("$mypop").offset().left,
	)();
	let popRightEdge_cafet = popRightEdge_cafe_1t + popRightEdge_cafe_0t;
	let btnRightEdge_cafe_2t = await ClientFunction(() =>
		jq("@button:eq(1)").outerWidth(),
	)();
	let btnRightEdge_cafe_3t = await ClientFunction(
		() => jq("@button:eq(1)").offset().left,
	)();
	let btnRightEdge_cafet = btnRightEdge_cafe_3t + btnRightEdge_cafe_2t;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(popRightEdge_cafet),
		ztl.normalizeText(btnRightEdge_cafet),
		ztl.normalizeText("2"),
	);
	await t.resizeWindow(1000, 800);
	let popRightEdge_cafe_0tt = await ClientFunction(() =>
		jq("$mypop").outerWidth(),
	)();
	let popRightEdge_cafe_1tt = await ClientFunction(
		() => jq("$mypop").offset().left,
	)();
	let popRightEdge_cafett = popRightEdge_cafe_1tt + popRightEdge_cafe_0tt;
	let btnRightEdge_cafe_2tt = await ClientFunction(() =>
		jq("@button:eq(1)").outerWidth(),
	)();
	let btnRightEdge_cafe_3tt = await ClientFunction(
		() => jq("@button:eq(1)").offset().left,
	)();
	let btnRightEdge_cafett = btnRightEdge_cafe_3tt + btnRightEdge_cafe_2tt;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(popRightEdge_cafett),
		ztl.normalizeText(btnRightEdge_cafett),
		ztl.normalizeText("2"),
	);
});
