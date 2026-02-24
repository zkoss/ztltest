import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2936095TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2936095TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    Please click dropdown button, and then the listitem displays well.
    <combobox id=\'cb\' onOpen=\'if(self.getItems().size()==0) if
(event.isOpen()) GetTableNames()\'/>
    <zscript>
        <![CDATA[
            public void GetTableNames ()
{
for (int i=1; i<=100; i++)
{
Comboitem ci = new Comboitem ("TableName" + i);
cb.appendChild (ci);
}
}
        ]]>
    </zscript>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("$cb")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(zk.Widget.$(jq(".z-combobox")).$n("pp"))[0],
			)(),
		)
		.ok();
});
