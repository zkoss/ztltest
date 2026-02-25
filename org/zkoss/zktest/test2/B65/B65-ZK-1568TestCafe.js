import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1568TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1568.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1568TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-overlapped:contains(1)")[0],
			)(),
		)
		.ok("Window 1, 3, 4, 5 should be visible while 2 should not");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-overlapped:contains(2)")[0],
			)(),
		)
		.notOk("Window 1, 3, 4, 5 should be visible while 2 should not");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-overlapped:contains(3)")[0],
			)(),
		)
		.ok("Window 1, 3, 4, 5 should be visible while 2 should not");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-overlapped:contains(4)")[0],
			)(),
		)
		.ok("Window 1, 3, 4, 5 should be visible while 2 should not");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-overlapped:contains(5)")[0],
			)(),
		)
		.ok("Window 1, 3, 4, 5 should be visible while 2 should not");
});
