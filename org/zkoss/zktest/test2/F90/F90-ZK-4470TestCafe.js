import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F90-ZK-4470TestCafe`
	.page`http://localhost:8080/zktest/test2/F90-ZK-4470.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F90-ZK-4470TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Widget.$("@treecol:eq(0)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Widget.$("@treecol:eq(0)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 <= verifyVariable_cafe_1_1)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(zk.Widget.$("@treecol:eq(1)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(zk.Widget.$("@treecol:eq(1)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0t <= verifyVariable_cafe_1_1t)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(0)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(0)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt <= verifyVariable_cafe_1_1tt)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(1)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(1)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttt <= verifyVariable_cafe_1_1ttt)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(2)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(2)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttt <= verifyVariable_cafe_1_1tttt)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(3)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(3)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttttt <= verifyVariable_cafe_1_1ttttt)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(23)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(23)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttttt <= verifyVariable_cafe_1_1tttttt)
		.ok("The content is overflowed!");
	await t.click(Selector(() => jq("@listheader:eq(3)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(0)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1ttttttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(0)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttttttt <= verifyVariable_cafe_1_1ttttttt,
		)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(1)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1tttttttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(1)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0tttttttt <= verifyVariable_cafe_1_1tttttttt,
		)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0ttttttttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(2)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1ttttttttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(2)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttttttttt <=
				verifyVariable_cafe_1_1ttttttttt,
		)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0tttttttttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(3)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1tttttttttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(3)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0tttttttttt <=
				verifyVariable_cafe_1_1tttttttttt,
		)
		.ok("The content is overflowed!");
	let verifyVariable_cafe_0_0ttttttttttt = await ClientFunction(
		() => jq(zk.Widget.$("@listheader:eq(23)").$n("cave"))[0].scrollWidth,
	)();
	let verifyVariable_cafe_1_1ttttttttttt = await ClientFunction(() =>
		jq(zk.Widget.$("@listheader:eq(23)").$n("cave")).outerWidth(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttttttttttt <=
				verifyVariable_cafe_1_1ttttttttttt,
		)
		.ok("The content is overflowed!");
});
