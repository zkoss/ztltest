import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3141610TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3141610.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3141610TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@menubar")).$n("right")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@menubar")).$n("left")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Widget.$(jq("@checkbox")).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@menubar")).$n("right")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@menubar")).$n("left")).is(":visible"),
			)(),
		)
		.ok();
});
