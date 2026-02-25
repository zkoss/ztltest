import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-528-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-528-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B50-ZK-528.zul"/>`);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("@listbox").find("col[id*=hdfaker][style*=collapse]").length,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("@listbox").find(".z-listheader").length,
	)();
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				verifyVariable_cafe_1_1 - verifyVariable_cafe_0_0,
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.find("col[id*=hdfaker][style*=collapse]")
						.attr("id"),
				)(),
			),
		)
		.notContains(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listheader").attr("id"))(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-listbox")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-listbox")).$n("empty"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Empty Message"));
	await t.click(Selector(() => jq("@div:last @button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-listbox")).$n("empty")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@div:last @button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-listbox")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@div:last @button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@div:last @button:eq(2)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq("@listbox").find("col[id*=hdfaker][style*=collapse]").length,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq("@listbox").find(".z-listheader").length,
	)();
	await t
		.expect(ztl.normalizeText("3"))
		.eql(
			ztl.normalizeText(
				verifyVariable_cafe_3_3 - verifyVariable_cafe_2_2,
			),
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-listbox")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@div:last @button:eq(3)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq("@listbox").find("col[id*=hdfaker][style*=collapse]").length,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq("@listbox").find(".z-listheader").length,
	)();
	await t.expect(verifyVariable_cafe_5_5 - verifyVariable_cafe_4_4 == 0).ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-listbox")).$n("empty")).is(":visible"),
			)(),
		)
		.ok();
});
