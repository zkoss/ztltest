import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-409TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-409.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-409TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-window-highlighted")).$n("close")),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("should not have modal window for exception");
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should not have any js error");
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-window-highlighted").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 1)
		.ok("only one highlighted window and contains expected message");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window")
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Question is pressed. Are you sure?"), "");
});
