import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-528TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-528.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-528TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("@grid").find(".z-column").length,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("@grid").find("col[id*=hdfaker][style*=collapse]").length,
	)();
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				verifyVariable_cafe_0_0 - verifyVariable_cafe_1_1,
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@grid")
						.find("col[id*=hdfaker][style*=collapse]")
						.attr("id"),
				)(),
			),
		)
		.notContains(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-column").attr("id"))(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@grid")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@grid")).$n("empty"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Empty Message"));
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@grid")).$n("empty")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@grid")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq("@grid").find(".z-column").length,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq("@grid").find("col[id*=hdfaker][style*=collapse]").length,
	)();
	await t
		.expect(ztl.normalizeText("3"))
		.eql(
			ztl.normalizeText(
				verifyVariable_cafe_2_2 - verifyVariable_cafe_3_3,
			),
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@grid")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@button:eq(3)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq("@grid").find(".z-column").length,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq("@grid").find("col[id*=hdfaker][style*=collapse]").length,
	)();
	await t.expect(verifyVariable_cafe_4_4 - verifyVariable_cafe_5_5 == 0).ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@grid")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
});
