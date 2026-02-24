import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1428TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1428TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <window title="Hello World!!" border="normal">
                      <label multiline="true">
                        Click the three "remove" button, should not see any error message.
                      </label>
                      <zscript><![CDATA[
		import org.zkoss.zul.*;
		import java.util.*;
		List items = new ArrayList();
		for (int i = 0; i<5; i++)
			items.add("Item " + i);
		ListModelList model1 = new ListModelList(items);
		ListModelList model2 = new ListModelList(items);
		ListModelList model3 = new ListModelList(items);
		model1.setMultiple(true);
		model2.setMultiple(true);
		model3.setMultiple(true);
		int size = model1.getSize();
		model1.setSelection(items.subList(size - 2, size));
		model2.setSelection(items.subList(size - 2, size));
		model3.setSelection(items.subList(size - 2, size));
		]]></zscript>
                      <listbox id="buggyremove1" multiple="true" model="\${model1}"/>
                      <button label="remove">
                        <attribute name="onClick"><![CDATA[
			ListModel m = buggyremove1.getModel();
			m.remove(size - 1);
			self.setDisabled(true);
			]]></attribute>
                      </button>
                      <separator spacing="30px"/>
                      <listbox id="buggyremove2" multiple="true" model="\${model2}"/>
                      <button label="remove">
                        <attribute name="onClick"><![CDATA[
			ListModel m = buggyremove2.getModel();
			for (Iterator it = m.iterator(); it.hasNext();) {
				String s = it.next();
				if (!s.equals("Item 0"))
					it.remove();
			}
			self.setDisabled(true);
			]]></attribute>
                      </button>
                      <separator spacing="30px"/>
                      <listbox id="buggyremove3" multiple="true" model="\${model3}"/>
                      <button label="remove">
                        <attribute name="onClick"><![CDATA[
			ListModel m = buggyremove3.getModel();
			for (Iterator it = m.listIterator(); it.hasNext();) {
				String s = it.next();
				if (!s.equals("Item 0"))
					it.remove();
			}
			self.setDisabled(true);
			]]></attribute>
                      </button>
                    </window>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("should not see any error message.");
});
