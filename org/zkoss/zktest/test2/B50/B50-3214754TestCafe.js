import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3214754TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3214754TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Please test the following cases:
	<separator/>
	1. type "test" into the textbox and focus out, it should alert an error.
	<separator/>

	2. clear the error popup and type "123" into the textbox and focus out, it shouldn\'t alert an error.
	<separator/>
	3. clear the error popup and type "12A3" into the textbox and focus out, they should alert an error.
	<separator/>
	<textbox constraint="/\\d+/"/>
	<separator/>
	4. Please test the step 1~3 with the following textbox as well.
	<separator/>
	<textbox constraint="/\\d*/"/>
</zk>`,
	);
	await ClientFunction(() => {
		jq(jq("@textbox:eq(0)"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox:eq(0)")[0]),
		ztl.normalizeText("test"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await t.click(Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")));
	await ClientFunction(() => {
		jq(jq("@textbox:eq(0)"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox:eq(0)")[0]),
		ztl.normalizeText("123"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await ClientFunction(() => {
		jq(jq("@textbox:eq(0)"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox:eq(0)")[0]),
		ztl.normalizeText("12A3"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await t.click(Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")));
	await ClientFunction(() => {
		jq(jq("@textbox:eq(0)"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox:eq(0)")[0]),
		ztl.normalizeText("123"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("@textbox:eq(1)"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox:eq(1)")[0]),
		ztl.normalizeText("test"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await t.click(Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")));
	await ClientFunction(() => {
		jq(jq("@textbox:eq(1)"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox:eq(1)")[0]),
		ztl.normalizeText("123"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await ClientFunction(() => {
		jq(jq("@textbox:eq(1)"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq("@textbox:eq(1)")[0]),
		ztl.normalizeText("12A3"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await t.click(Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")));
});
