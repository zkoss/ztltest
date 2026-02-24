import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z-Userguide-FormTestCafe`
	.page`http://localhost:8080/zktest/test2/Z-Userguide-Form.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("Z-Userguide-FormTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("$view").find("@textbox:eq(0)")[0].value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq("$view").find("@textbox:eq(0)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$view").find("@textbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("J u m p e r");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$view").find("@textbox:eq(0)")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Jumper"));
	await ClientFunction(() => {
		jq("$view").find("@textbox:eq(1)")[0].value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq("$view").find("@textbox:eq(1)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$view").find("@textbox:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3 4");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$view").find("@textbox:eq(1)")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1234"));
	await ClientFunction(() => {
		jq("$view").find("@textbox:eq(2)")[0].value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq("$view").find("@textbox:eq(2)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$view").find("@textbox:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3 4");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$view").find("@textbox:eq(2)")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1234"));
	await ClientFunction(() => {
		jq("$view").find("@intbox:eq(0)")[0].value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq("$view").find("@intbox:eq(0)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$view").find("@intbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3 4");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$view").find("@intbox:eq(0)")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1234"));
	await ClientFunction(() => {
		jq("$view").find("@intbox:eq(1)")[0].value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq("$view").find("@intbox:eq(1)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$view").find("@intbox:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3 4 5");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$view").find("@intbox:eq(1)")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("12345"));
	await ClientFunction(() => {
		jq("@decimalbox")[0].value = "";
	})();
	if (
		await ClientFunction(
			() => jq(jq("@decimalbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("@decimalbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 . 3 4 5");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(jq("@decimalbox")).val())(),
			),
		)
		.eql(ztl.normalizeText("12.34"));
	await ClientFunction(() => {
		jq("$view").find("@textbox:eq(4)")[0].value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(jq("$view").find("@textbox:eq(4)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$view").find("@textbox:eq(4)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("z k");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-errorbox").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Please enter an e-mail address"), "");
	if (
		await ClientFunction(
			() =>
				jq(jq("$view").find("@textbox:eq(4)"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$view").find("@textbox:eq(4)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("z k @ z k o s s . o r g");
	await t.pressKey("tab");
	await ClientFunction(() => {
		jq("$intro").focus();
	})();
	await ztl.waitResponse(t);
	await t.wait(500);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await t.click(Selector(() => zk.Widget.$(jq(".z-spinner")).$n("btn-up")));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() =>
			jq(zk.Widget.$(jq("@spinner")).$n("real")).val(),
		)(),
	);
	await t.expect(3 < verifyVariable_cafe_0_0).ok();
	await t.click(
		Selector(() => zk.Widget.$(jq("@spinner")).$n("btn-down")),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() =>
			jq(zk.Widget.$(jq("@spinner")).$n("real")).val(),
		)(),
	);
	await t.expect(4 >= verifyVariable_cafe_1_1).ok();
	await t
		.click(Selector(() => zk.Widget.$(jq("@colorbox")).$n("currcolor")))
		.click(Selector(() => jq(".z-colorpalette-color:eq(56)")[0]))
		.click(Selector(() => zk.Widget.$(jq("@colorbox")).$n("currcolor")))
		.click(Selector(() => zk.Widget.$(jq(".z-colorbox")).$n("picker-btn")));
	await ztl.waitResponse(t);
	let currColor_cafe = await ClientFunction(
		() =>
			zk.Widget.$(jq("@colorbox")).$n("currcolor").style.backgroundColor,
	)();
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText(
					await ClientFunction(() =>
						zk.Widget.$(jq("@colorbox")).getValue(),
					)(),
				),
				ztl.normalizeText(
					await ClientFunction(
						() =>
							zk.Widget.$(jq("@colorbox")).$n("currcolor").style
								.backgroundColor,
					)(),
				),
			),
		)
		.ok();
});
