import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2941TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2941.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2941TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	let cbbid_cafe = await ClientFunction(() => jq("@combobutton")[0].id)();
	await ClientFunction(() => {
		jq("$btn").focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq(":focus")).uuid)(),
			),
		)
		.eql(ztl.normalizeText(cbbid_cafe));
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq(":focus")).uuid)(),
			),
		)
		.eql(ztl.normalizeText(cbbid_cafe));
	await t.pressKey("space");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq(":focus")).uuid)(),
			),
		)
		.eql(ztl.normalizeText(cbbid_cafe));
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-menupopup")[0]).is(":visible"),
			)(),
		)
		.ok();
	await t.pressKey("esc");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-menupopup")[0]).is(":visible"),
			)(),
		)
		.notOk();
});
