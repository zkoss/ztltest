import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F85-ZK-3844TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3844.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3844TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@button:eq(0) i").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 0).ok("button 1 icon missing");
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq("@button:eq(1) i").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0t > 0).ok("button 2 icon missing");
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq("@button:eq(2) i").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0tt > 0).ok("button 3 icon missing");
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq("@button:eq(3) i").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0ttt > 0).ok("button 4 icon missing");
	await t
		.expect(
			await ClientFunction(() =>
				jq("@label:contains(6. The following)").is(":visible"),
			)(),
		)
		.ok();
});
