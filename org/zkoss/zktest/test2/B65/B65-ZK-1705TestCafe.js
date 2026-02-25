import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1705TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1705TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
	<zscript><![CDATA[
	    String[] data = new String[3];
	    data[0] = "c3";
	    data[1] = "a1";
	    data[2] = "b2";
		ListModelList listModel = new ListModelList(data);
	]]>
	</zscript>

	<div>Sort the list by clicking either of the buttons. No NullPointerException should appear</div>
	<button label="Sort Values (asc)" onClick="listModel.sort(null, true)" />
	<button label="Sort Values (desc)" onClick="listModel.sort(Collections.reverseOrder(), false)" />

	<listbox id="grid" model="\${listModel}">
		<template name="model">
			<listitem>
				<listcell>
					<label value="\${each}" />
				</listcell>
			</listitem>
		</template>
	</listbox>
</vbox>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(asc)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
	await t.click(Selector(() => jq(".z-button:contains(desc)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
});
