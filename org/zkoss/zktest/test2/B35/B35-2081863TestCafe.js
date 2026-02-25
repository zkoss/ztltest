import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2081863TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2081863TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="win1" title="ztl" >
	After the page loaded, if you don\'t see any popup or alert , this bug fixed
<hbox spacing="0" width="150px">
<tabbox id="Tab1" onSelect="refresh()" width="780px">
<tabs>
<tab label="Tp1" />
<tab label="Tp2" />
<tab label="Exit" />
</tabs>
<tabpanels>

<tabpanel id="tp1">
</tabpanel>

<tabpanel id="tp2">
</tabpanel>

<tabpanel id="exit">
</tabpanel>
</tabpanels>
</tabbox>
</hbox>
<zscript>

public void refresh() {

if (Tab1.getSelectedPanel().getId().equals("tp1"))
{
alert("tp1");
}
if (Tab1.getSelectedPanel().getId().equals("tp2"))
{
alert("tp2");
}
if (Tab1.getSelectedPanel().getId().equals("exit"))
{
alert("exit");
}
}
</zscript>
</window>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq('@window:not(@window[title="ztl"])')[0],
			)(),
		)
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-popup")[0])()).notOk();
});
