import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1303TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1303TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>
                      Ste 1: Click "update"<separator/>
                      Step 2: Select first item in the lsitbox "test1"<separator/>
                      Step 3: Click "test"<separator/>
                      Message box should show "test1"
                    </div>
                    <window border="normal" title="hello" width="400px" height="400px">
                      <label value="test"/>
                      <listbox id="listbox" mold="select" rows="1" onSelect=""></listbox>
                      <button id="btn2" label="update" onClick="update();"/>
                      <button id="btn" label="test" onClick=\'Messagebox.show(listbox.getSelectedItem().getValue().toString());\'/>
                      <zscript>
                        <![CDATA[
	listbox.getItems().clear();
	Listitem li = new Listitem("test3", "test3");
	li.setSelected(true);
	li.setParent(listbox);
	public void update() {
		listbox.getItems().clear();
		Listitem li = new Listitem("test1", "test1");
		li.setParent(listbox);
		li = new Listitem("test2", "test2");
		li.setParent(listbox);
		li = new Listitem("test3", "test3");
		li.setSelected(true);
		li.setParent(listbox);
	}
]]>
                      </zscript>
                    </window>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button:contains(update)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => !!jq(".z-option:contains(test1)")[0])(),
		)
		.ok();
	await t
		.click(Selector(() => jq(jq(".z-select"))[0]))
		.click(
			Selector(
				() => jq(jq(".z-select")).find("option:contains(test1)")[0],
			),
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:contains(test)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("test1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
