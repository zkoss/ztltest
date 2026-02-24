import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1826517TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1826517TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
       
       <div>This case we need to make sure the column width is same after set visiable false.</div>
       <div> 1. click the button , and check the width . </div>
	<listbox width="400px">
		<listhead id="hd" sizable="true" visible="false">
			<listheader width="50px" label="name" sort="auto"/>
			<listheader label="Column2" sort="auto"/>
		</listhead>
		<listitem>
			<listcell label="Mary"/>
			<listcell label="FEMALE"/>
		</listitem>
		<listitem>
			<listcell label="John"/>
			<listcell label="MALE"/>
		</listitem>
	</listbox>
	<button label="visible" onClick=\'hd.visible = !hd.visible\'/>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => jq("@listhead").is(":visible"))())
		.notOk();
	let width1_cafe = await ClientFunction(() =>
		jq("@listcell").eq(0).outerWidth(),
	)();
	let width2_cafe = await ClientFunction(() =>
		jq("@listcell").eq(1).outerWidth(),
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@listhead").is(":visible"))())
		.ok();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width1_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listcell").eq(0).outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width1_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listheader").eq(0).outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width2_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listcell").eq(1).outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width2_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listheader").eq(1).outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@listhead").is(":visible"))())
		.notOk();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width1_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listcell").eq(0).outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width2_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listcell").eq(1).outerWidth())(),
		),
		ztl.normalizeText("1"),
	);
});
