import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2548TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2548TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. Set focus on the first combobox\'s text input box
	2. Press "down arrow" key to change its selection
	3. Press "tab" to set focus on the second combobox, model should be set
	</label>
    <zscript><![CDATA[
    ListModelList items = new ListModelList();
    items.add("d1");
    items.add("d2");
    items.add("d3");
    
    ListModelList otherItems = null;
    
    ListModelList sub1 = new ListModelList();
    sub1.add("d1s1");
    sub1.add("d1s2");
    sub1.add("d1s3");
    
    ListModelList sub2 = new ListModelList();
    sub2.add("d2s1");
    sub2.add("d2s2");
    sub2.add("d2s3");

    ListModelList sub3 = new ListModelList();
    sub3.add("d3s1");
    sub3.add("d3s2");
    sub3.add("d3s3");

    void doSelect(String value) {
        System.out.println("doSelect: " + value);
        if ("d1".equals(value))
            secondCombo.setModel(sub1);
        else if ("d2".equals(value))
            secondCombo.setModel(sub2);
        else
            secondCombo.setModel(sub3);
    }
    ]]></zscript>
    <combobox id="firstCombo"
        model="\${items}"
        onSelect="doSelect(self.value)"
        constraint="no empty"/>
    <combobox id="secondCombo"
        constraint="no empty"/>
</zk>`,
	);
	await ClientFunction(() => {
		jq(".z-combobox-input").eq(0).focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-input").eq(0).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("d1"));
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-combobox-input").eq(1).focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-input").eq(1).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("d1s1"));
});
