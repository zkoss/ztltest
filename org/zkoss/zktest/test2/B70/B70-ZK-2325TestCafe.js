import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2325TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2325TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2325.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 18, 2014  9:55:12 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div>
		if the separators still occupy 1 or 2px even if spacing="0px", that\'s a bug.
	</div>
    <label value=\'1. hbox spacing="0"\'/>
    <hbox spacing="0" width="500px" height="55px" style="background:yellow">
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
    </hbox>
    
    <label value=\'2. hbox spacing="0px"\'/>
    <hbox spacing="0px" width="500px" height="55px" style="background:yellow">
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
    </hbox>
    
    <label value=\'3. vbox spacing="0"\'/>
    <vbox spacing="0" width="105px" height="250px" style="background:yellow">
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
    </vbox>

    <label value=\'4. vbox spacing="0px"\'/>
    <vbox spacing="0px" width="105px" height="250px" style="background:yellow">
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
    </vbox>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(0).width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 0 || s.css("display") == "none")
		.ok("seperator shouldn't occupy 1 or 2px");
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(1).width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0t == 0 || s.css("display") == "none")
		.ok("seperator shouldn't occupy 1 or 2px");
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(2).width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt == 0 || s.css("display") == "none")
		.ok("seperator shouldn't occupy 1 or 2px");
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(3).width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttt == 0 || s.css("display") == "none")
		.ok("seperator shouldn't occupy 1 or 2px");
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(4).width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttt == 0 || s.css("display") == "none")
		.ok("seperator shouldn't occupy 1 or 2px");
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(5).width(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttttt == 0 || s.css("display") == "none")
		.ok("seperator shouldn't occupy 1 or 2px");
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(6).width(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0tttttt == 0 || s.css("display") == "none",
		)
		.ok("seperator shouldn't occupy 1 or 2px");
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(() =>
		jq(".z-hbox-separator").eq(7).width(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttttttt == 0 || s.css("display") == "none",
		)
		.ok("seperator shouldn't occupy 1 or 2px");
});
