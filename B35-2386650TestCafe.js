import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2386650TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2386650TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<tabbox id=\'tbStats\'>
</tabbox>
<button label="Click me once if no error, that is correct" onClick="InitTabbox(); self.disabled = true"/>
<zscript>
public void InitTabbox ()
{
Tabs tabs = new Tabs ();
Tabpanels tps = new Tabpanels ();
Tab t = new Tab ("Tab1");
t.setAttribute ("code","ShenZhen");
t.setAttribute ("name", "new Tab");
tabs.appendChild (t);
tbStats.appendChild (tabs);
}
//InitTabbox ();
</zscript>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
});
