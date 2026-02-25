import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-2880TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B80-ZK-2880TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2880.zul

	Purpose:
		
	Description:
		
	History:
		Fri Sep 18 11:34:57 CST 2015, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.

-->
<zk>
    <window viewModel="@id(\'vm\') @init(\'org.zkoss.zktest.test2.B80_ZK_2880ViewModel\')">
        <vbox>
            <button label="Direct Click me, you should not see the new item added outside the combobox"
                    onClick="@command(\'buttonClick\')"/>

            <combobox model="@load(vm.list)">
                <template name="model">
                    <comboitem value="@bind(each)" label="@bind(each.name)"/>
                </template>
            </combobox>
        </vbox>
    </window>
</zk>`,
	);
	await t.click(Selector(() => jq("button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(
						".z-comboitem:not(.z-combobox-content > .z-comboitem)",
					)[0],
			)(),
		)
		.notOk();
});
