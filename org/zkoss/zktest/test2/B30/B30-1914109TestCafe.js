import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1914109TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1914109TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:ol>
          <n:li>
            Click set a smaller height button, and you should see the listbox
is shorter and has a scroll bar
          </n:li>
        </n:ol>
        <window title="Live Data Demo" border="normal">
          <button label="set a smaller height" onClick=\'list.height="150px"\'/>
          <zscript><![CDATA[
            List items = new org.zkoss.zktest.test2.BigList(100);
    		ListModel strset = new ListModelList(items);
    		ListitemRenderer render = new ListitemRenderer(){
              public void render(Listitem item, Object data, int index) {
                new Listcell("col - " + item.getIndex()).setParent(item);
                new Listcell("col - " + item.getIndex()).setParent(item);
                new Listcell("col - " + item.getIndex()).setParent(item);
                new Listcell("col - " + item.getIndex()).setParent(item);
                new Listcell("col - " + item.getIndex()).setParent(item);
              }
            }
            ;
          ]]></zscript>
          <listbox id="list" width="100%" model="&#36;{strset}" itemRenderer="\${render}" mold="paging" pagingPosition="both">
            <listhead sizable="true">
              <listheader label="Col 1" sort="auto"/>
              <listheader label="Col 2" sort="auto"/>
              <listheader label="Col 3" sort="auto"/>
              <listheader label="Col 4" sort="auto"/>
              <listheader label="Col 5" sort="auto"/>
            </listhead>
          </listbox>
        </window>
      </zk>`,
	);
	let height_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("list", true)).outerHeight(),
	)();
	let scrollH_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("list", true))[0].scrollHeight,
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("list", true)).outerHeight(),
	)();
	await t.expect(height_cafe > verifyVariable_cafe_0_0).ok();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("list", true)).outerHeight(),
	)();
	await t.expect(200 > verifyVariable_cafe_1_1).ok();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("list", true))[0].scrollHeight,
	)();
	await t.expect(scrollH_cafe > verifyVariable_cafe_2_2).ok();
});
