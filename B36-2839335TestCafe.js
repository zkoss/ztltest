import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2839335TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2839335.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2839335TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq("@timebox")).$n("real")));
	await ClientFunction(() => {
		zk(zk.Widget.$(jq("@timebox")).$n("real")).setSelectionRange(0, 0);
	})();
	await ztl.waitResponse(t);
	let old_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@timebox")).$n("real")).val(),
	)();
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq("@timebox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("@timebox")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("A");
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq("@timebox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq("@timebox")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("X");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText(old_cafe));
});
