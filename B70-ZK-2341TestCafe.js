import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2341TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2341.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2341TestCafe", async (t) => {
	await ztl.initTest(t);
	let left_cafe = await ClientFunction(
		() => jq("@cardlayout").offset().left,
	)();
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			parseInt(
				await ClientFunction(
					() =>
						jq("span:contains(this is page 2-1)")
							.closest("table")
							.parent()
							.offset().left,
				)(),
			),
		),
		ztl.normalizeText(left_cafe),
		ztl.normalizeText("10"),
	);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			parseInt(
				await ClientFunction(
					() =>
						jq("span:contains(this is page 3-1)")
							.closest("table")
							.parent()
							.offset().left,
				)(),
			),
		),
		ztl.normalizeText(left_cafe),
		ztl.normalizeText("10"),
	);
	await t.click(Selector(() => jq("@button").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			parseInt(
				await ClientFunction(
					() =>
						jq("span:contains(this is page 4-1)")
							.closest("table")
							.parent()
							.offset().left,
				)(),
			),
		),
		ztl.normalizeText(left_cafe),
		ztl.normalizeText("10"),
	);
});
