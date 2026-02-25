import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1512TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1512TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <label multiline="true">
                      1. Click "Set Data" (setModel).
2. Click Listbox "Select All" Checkbox. No Scroll.
3. Click "Set Data".
4. Scroll to bottom, if the 51 - 100 data has checkbox selected, it is a bug.
5. Click "popup window".
6. Click "Set Data" inside popup window.
7. Click Listbox "Select All" Checkbox inside popup window.
8. Click "Set Data" again.
9. Listbox "Select All" Checkbox should work correctly.
                    </label>
                    <window id="win" apply="org.zkoss.zktest.test2.B60_ZK_1512_Composer">
                      <button id="btn1" label="Set Data"/>
                      <button id="btn2" label="Clear Data"/>
                      <button id="btn4" label="Show Select Number"/>
                      <button id="btn3" label="popup window"/>
                      <listbox id="lb" multiple="true" checkmark="true" height="500px" width="500px">
                        <custom-attributes org.zkoss.zul.listbox.rod="false"/>
                        <listhead>
                          <listheader width="30px"/>
                          <listheader label="1"/>
                          <listheader label="2"/>
                          <listheader label="3"/>
                          <listheader label="4"/>
                        </listhead>
                        <template name="model">
                          <listitem>
                            <listcell label=""/>
                            <listcell label="\${each}-1"/>
                            <listcell label="\${each}-2"/>
                            <listcell label="\${each}-3"/>
                            <listcell label="\${each}-4"/>
                          </listitem>
                        </template>
                      </listbox>
                    </window>
                  </zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(Set Data)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-listheader").find(".z-listheader-checkable")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Set Data)")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-listbox-body")[0].scrollTop = 2500;
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("tbody[id*=rows]").find(".z-listitem-selected").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 >= 50)
		.notOk("if the 51 - 100 data has checkbox selected, it is a bug.");
	await t.click(Selector(() => jq(".z-button:contains(popup)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-window-modal").find(".z-button:contains(Set Data)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(".z-window-modal")
					.find(".z-listheader")
					.find(".z-listheader-checkable")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-window-modal").find(".z-button:contains(Set Data)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(".z-window-modal")
					.find(".z-listheader")
					.find(".z-listheader-checkable")[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-window-modal .z-listitem-selected").length,
				)(),
			),
		)
		.eql(
			ztl.normalizeText("10"),
			"Listbox 'Select All' Checkbox should work correctly.",
		);
});
