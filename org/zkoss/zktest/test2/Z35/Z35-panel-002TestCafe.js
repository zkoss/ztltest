import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z35-panel-002TestCafe`
	.page`http://localhost:8080/zktest/test2/Z35-panel-002.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("Z35-panel-002TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq("$btn1")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("exp")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq("$btn2")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("exp")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("min")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq("$btn3")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("exp")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("min")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("max")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq("$btn4")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("exp")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("min")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("max")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("close")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq("$btn3")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("exp")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("min")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("close")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq("$btn3")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("exp")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("min")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("max")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@panel")).$n("close")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq("$btnFloat")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("absolute"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-panel").css("position"))(),
			),
		);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-panel-header-move").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 0).ok();
	await t.click(
		Selector(() => jq("$btnMove")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-panel-header-move").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 == 1).ok();
	await t.click(
		Selector(() => jq("$btnFloat")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("absolute"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-panel").css("position"))(),
			),
			"",
		);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-panel-header-move").length,
	)();
	await t.expect(verifyVariable_cafe_2_2 == 0).ok();
	await t.click(
		Selector(() => jq(zk.Widget.$(jq("@panel")).$n("exp"))[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			await ClientFunction(() => jq(".z-panel-body").is(":visible"))(),
		)
		.notOk();
	await t.click(
		Selector(() => jq(zk.Widget.$(jq("@panel")).$n("exp"))[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			await ClientFunction(() => jq(".z-panel-body").is(":visible"))(),
		)
		.ok();
});
