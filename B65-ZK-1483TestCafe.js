import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1483TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1483.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1483TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button:contains(Select All)")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-listbox-body")[0].scrollTop = 360;
	})();
	await ClientFunction(() => {
		jq(".z-listbox-body")[0].scrollTop = 720;
	})();
	await t.wait(500);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-listbox-body").scrollTop(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 720)
		.ok("The scrollbar position should not vibrate when released.");
});
