import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-423TestCafe`
	.page`http://localhost:8080/zktest/test2/F60-ZK-423.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F60-ZK-423TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("safari")) {
		console.log("This issue is ignored in current browser! (safari)");
		return;
	}
	await t.click(Selector(() => zk.Desktop._dt.$f("tbxOne", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tbxTwo", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("true"),
			"First listitem should be selected",
		);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tbxOne", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("true"),
			"First listitem should be selected",
		);
});
