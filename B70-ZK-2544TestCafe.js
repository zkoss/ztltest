import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2544TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2544TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2544.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Feb 26, 2015 10:13:08 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:w="client">
	Please click the combobox\'s button, the listitem should be selected, and you should not see any "clicked" in zk client log
    <zscript><![CDATA[
    ListModelList model = new ListModelList();
    model.add("1");
    model.add("2");
    model.add("3");
    ]]></zscript>
    <listbox model="\${model}" nonselectableTags="" onSelect="System.out.println(self.selectedItem)" width="100%">
        <listhead>
            <listheader label="Combobox" width="100px" />
            <listheader label="Textbox"  />
        </listhead>
        <template name="model" var="record">
            <listitem value="\${record}" onClick=\'Clients.log("Clicked")\'>
                <listcell>
                    <combobox model="\${model}" width="100%">
                        <template name="model" var="option">
                            <comboitem label="\${option}" />
                        </template>
                    </combobox>
                </listcell>
                <listcell>
                    <textbox />
                    <button label="test" />
                </listcell>
            </listitem>
        </template>
    </listbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-combobox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("Clicked"), "");
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-listitem").eq(0).hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
});
