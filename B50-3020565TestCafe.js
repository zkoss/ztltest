import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3020565TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3020565TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    <tabbox>
     <tabs>
      <tab label="a" />
      <tab label="b" id="b"/>
     </tabs>
     <tabpanels>
      <tabpanel>Click "header" and then "item" buttons. Then, click the "b" tab to see
      the listbox has a header and an item.</tabpanel>
      <tabpanel>
       <listbox id="lb" width="300px"></listbox>
      </tabpanel>
     </tabpanels>
    </tabbox>
    
    <button id="btn" label="header">
     <attribute name="onClick"><![CDATA[
   Listhead listhead = new Listhead();
   listhead.appendChild(new Listheader("header"));
   listhead.setParent(lb);
  ]]></attribute>
 </button>
 <button id="btn1" label="item">
     <attribute name="onClick"><![CDATA[
   lb.appendChild(new Listitem("item"));
  ]]></attribute>
 </button>
  <button id="btn2" label="all">
     <attribute name="onClick"><![CDATA[
   Listhead listhead = new Listhead();
   listhead.appendChild(new Listheader("header"));
   listhead.setParent(lb);
   
   for(int i = 0; i < 20;i++)
    lb.appendChild(new Listitem("item"));
   
  ]]></attribute>
 </button>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("b", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("@listbox @listheader")[0])())
		.ok();
	await t
		.expect(await ClientFunction(() => !!jq("@listbox @listitem")[0])())
		.ok();
});
