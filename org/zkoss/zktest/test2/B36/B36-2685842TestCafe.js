import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2685842TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2685842.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2685842TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window:contains(My First Window)")[0],
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-panel:contains(My First Panel)")[0],
			)(),
		)
		.ok();
});
