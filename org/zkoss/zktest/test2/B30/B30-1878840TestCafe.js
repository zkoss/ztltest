import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1878840TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1878840TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:p>You can scroll down the listbox to end, and then click the listheader to sort the live data.</n:p>
        <n:p>Then you should\'t see that the content containing some empty content.</n:p>
        <window title="Live Data Demo" border="normal">
    	  <script><![CDATA[
    		function doScrollDown() {
    			var $jq = jq(zk.Widget.$(\'$list\').$n(\'body\'));
    			$jq.scrollTop($jq[0].scrollHeight);
    			return true;
    		}
    	  ]]></script>
          <zscript><![CDATA[
            List items = new org.zkoss.zktest.test2.BigList(100);
    		ListModel strset = new ListModelList(items);
    		ListitemRenderer render = new ListitemRenderer(){
              public void render(Listitem item, Object data, int index) {
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
                new Listcell("col - " + data).setParent(item);
              }
            }
            ;
          ]]></zscript>
          <listbox id="list" width="400px" rows="20" model="&#36;{strset}" itemRenderer="\${render}">
            <listhead sizable="true">
              <listheader label="Col 1" sort="auto"/>
              <listheader label="Col 2" sort="auto"/>
              <listheader label="Col 3" sort="auto"/>
              <listheader label="Col 1" sort="auto"/>
              <listheader label="Col 2" sort="auto"/>
              <listheader label="Col 3" sort="auto"/>
            </listhead>
          </listbox>
        </window>
      </zk>`,
	);
	await ClientFunction(() => {
		doScrollDown();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listheader")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listheader")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-listcell:empty")[0] != null)(),
		)
		.notOk();
});
