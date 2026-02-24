import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1222TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1222.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1222TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t
		.hover(
			Selector(
				() => jq(".z-listitem:contains(Mouse hover - tooltip)")[0],
			),
		)
		.wait(1000);
	await t
		.expect(await ClientFunction(() => !!jq(".z-popup")[0])())
		.ok("should see a tooltip loading for about 2 seconds.");
	await t
		.expect(await ClientFunction(() => !!jq(".z-apply-mask")[0])())
		.ok("should see a tooltip loading for about 2 seconds.");
	await t.wait(500);
	await t
		.expect(await ClientFunction(() => !!jq(".z-popup")[0])())
		.ok(
			"If you see the tooltip appearing and disappearing several times while it is loading, it is an error.",
		);
	await t.wait(1500);
	await t
		.expect(await ClientFunction(() => !!jq(".z-apply-mask")[0])())
		.notOk();
	await t.click(
		Selector(() => jq(".z-listcell:contains(Click - popup)")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(await ClientFunction(() => jq(jq(".z-popup")).is(":visible"))())
		.ok(
			"Then, the tooltip should keep displaying until the mouse cursor is click outside the second data row.",
		);
	await t.click(
		Selector(() => jq(".z-listhead")[0]),
		{ offsetX: 3, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(await ClientFunction(() => jq(".z-popup").is(":visible"))())
		.notOk(
			"Then, the tooltip should keep displaying until the mouse cursor is click outside the second data row.",
		);
});
