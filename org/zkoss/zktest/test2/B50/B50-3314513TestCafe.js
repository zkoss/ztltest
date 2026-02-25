import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3314513TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3314513TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
					<ol>
						<li>Type "abc" in the following 4 dateboxes. All four should show errors.</li>
					</ol>
				]]></html>
    			<label id="outer" value="outer" />
    			<div></div>
				<label id="lb1" value="en_US: " />
				<datebox id="dbx1" locale="en_US" />
				<separator />
				<label value="zh_TW: " />
				<datebox id="dbx2" locale="zh_TW" />
				<separator />
				<label value="de_DE: " />
				<datebox id="dbx3" locale="de_DE" />
				<separator />
				<label value="fr_FR: " />
				<datebox id="dbx4" locale="fr_FR" />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("dbx1", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("dbx1", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("dbx1", true).$n("real")),
		ztl.normalizeText("abc"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("dbx2", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("dbx2", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("dbx2", true).$n("real")),
		ztl.normalizeText("abc"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("dbx3", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("dbx3", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("dbx3", true).$n("real")),
		ztl.normalizeText("abc"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("dbx4", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("dbx4", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("dbx4", true).$n("real")),
		ztl.normalizeText("abc"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("outer", true).$n()));
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 4)
		.ok("all four datebox should show error");
});
