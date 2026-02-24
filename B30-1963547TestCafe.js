import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1963547TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1963547TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
It is true, if don\'t have any JS error after you go through the following steps
<vbox>
<listbox width="250px" id="list">
<listhead/>
</listbox>
<button label="Click Me Three Times" onClick=\'new Listitem("WithListhead").parent=list;\'/>

<listbox width="250px" id="list1">
<listfoot/>
</listbox>
<button label="Click Me Three Times"  onClick=\'new Listitem("WithListfoot").parent=list1;\'/>
<listbox width="250px" id="list2" mold="paging"/>
<button label="Click Me Three Times"  onClick=\'new Listitem("OnlyPaging").parent=list2;\'/>
</vbox>
</zk>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
