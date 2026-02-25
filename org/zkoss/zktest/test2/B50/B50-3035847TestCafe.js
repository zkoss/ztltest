import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3035847TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3035847TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Click the drop-down button, and the combobox shall be detached.
	<separator/>
	Bug: the popup remains when combobox is detached.
	<separator/>
	<combobox id="cb" onOpen="self.detach()">
		<comboitem forEach="1,1,1,1,1,1,1" label="item" />
	</combobox>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@comboitem")[0])()).notOk();
});
