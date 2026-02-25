import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1892464TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1892464TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="mainwin">
    			If you see two same groupbox, it is correct!
    			<groupbox id="gbx2">
    				<caption label="caption2"/>
    				<label value="clone a groupbox"/>
    			</groupbox>

    			<zscript>
    				Groupbox gbx3 = gbx2.clone();
    				gbx3.setId("gbx3");
    				gbx3.setParent(mainwin);
    			</zscript>
    		</window>`,
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$gbx2")[0])()).ok();
	await t.expect(await ClientFunction(() => !!jq("$gbx3")[0])()).ok();
	await t
		.expect(await ClientFunction(() => jq("$gbx2").is(":visible"))())
		.ok();
	await t
		.expect(await ClientFunction(() => jq("$gbx3").is(":visible"))())
		.ok();
	let c1_cafe = await ClientFunction(() =>
		jq(jq(jq("$gbx2").find("@caption")))
			.text()
			.replace(/\s/g, " "),
	)();
	let c2_cafe = await ClientFunction(() =>
		jq(jq(jq("$gbx3").find("@caption")))
			.text()
			.replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(c2_cafe)).eql(ztl.normalizeText(c1_cafe));
	let l1_cafe = await ClientFunction(() =>
		jq(jq(jq("$gbx2").find("@label")))
			.text()
			.replace(/\s/g, " "),
	)();
	let l2_cafe = await ClientFunction(() =>
		jq(jq(jq("$gbx3").find("@label")))
			.text()
			.replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText(l2_cafe)).eql(ztl.normalizeText(l1_cafe));
});
