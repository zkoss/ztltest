import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2003TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2003.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2003TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-combobox")).$n("btn")));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0)
		.ok("the combobox popup will show up");
	await t
		.drag(
			Selector(() => zk.Widget.$(jq(".z-north")).$n("split")),
			0,
			2,
			{ offsetX: 2, offsetY: 2 },
		)
		.wait(1000);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
	)();
	await t
		.expect(verifyVariable_cafe_1_1)
		.notOk("the combobox popup must be hidden");
	await t.click(Selector(() => zk.Widget.$(jq(".z-bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).is(":visible"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0t)
		.ok("the bandbox popup will show up");
	await t
		.drag(
			Selector(() => zk.Widget.$(jq(".z-north")).$n("split")),
			0,
			2,
			{ offsetX: 2, offsetY: 2 },
		)
		.wait(1000);
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).is(":visible"),
	)();
	await t
		.expect(verifyVariable_cafe_1_1t)
		.notOk("the bandbox popup must be hidden");
});
