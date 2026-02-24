import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-989TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-989TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>1. Select item 3.</div>
                    <div>2. Click \'Disabled\' Button.</div>
                    <div>3. Select item 4, and click \'Get Selected\' Button. You should see "4" next to the button.</div>
                    <div>4. Select item 3, and click \'Get Selected\' Button. You should see "3".</div>
                    <listbox id="listbox" mold="select">
                      <listitem id="item\${each}" value="\${each}" label="\${each}" forEach="1,2,3,4"/>
                    </listbox>
                    <button label="Disable" onClick="item2.visible=false;"/>
                    <button label="Get Selected" onClick="selectedValue.value=listbox.getSelectedItem().getValue();"/>
                    <label value="" id="selectedValue"/>
                  </zk>`,
	);
	await t
		.click(Selector(() => jq(jq(".z-select"))[0]))
		.click(
			Selector(() => jq(jq(".z-select")).find("option:contains(3)")[0]),
		)
		.click(Selector(() => jq(".z-button:contains(Disable)")[0]));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq(jq(".z-select"))[0]))
		.click(
			Selector(() => jq(jq(".z-select")).find("option:contains(4)")[0]),
		)
		.click(Selector(() => jq(".z-button:contains(Get Selected)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-label:contains(4)")[0])())
		.ok("should see '4' next to the button.");
	await t
		.click(Selector(() => jq(jq(".z-select"))[0]))
		.click(
			Selector(() => jq(jq(".z-select")).find("option:contains(3)")[0]),
		)
		.click(Selector(() => jq(".z-button:contains(Get Selected)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-label:contains(3)")[0])())
		.ok("should see '3'");
});
