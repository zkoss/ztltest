import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2308TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2308.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2308TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9,ie10,ie11")) {
		console.log(
			"This issue is ignored in current browser! (ie9,ie10,ie11)",
		);
		return;
	}
	await t.click(
		Selector(() => jq(".z-datebox-input")[0]),
		{ offsetX: 3, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-datebox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-datebox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("alt+down");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-datebox-popup")[0])())
		.ok("should see datebox popup.");
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("esc");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-datebox-popup").is(":visible"))(),
		)
		.notOk("should see datebox popup closed.");
});
