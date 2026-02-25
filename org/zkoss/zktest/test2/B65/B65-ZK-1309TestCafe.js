import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1309TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1309.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1309TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:contains(Open)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-window-modal").is(":visible"))(),
		)
		.ok("should show modal window");
	await t.click(Selector(() => jq(".z-button:contains(click)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-notification").is(":visible"))(),
		)
		.ok("should show notification");
	await t.drag(
		Selector(() => jq(".z-window-header-move")[0]),
		50,
		0,
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-modal-mask").is(":visible"))(),
		)
		.ok("the mask of modal window can't disappear");
	await t
		.expect(
			await ClientFunction(() => jq(".z-notification").is(":visible"))(),
		)
		.notOk("should hide notification");
});
