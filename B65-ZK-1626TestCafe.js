import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1626TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1626TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
You should only see "Visible row" below this line. Otherwise, that\'s a bug.
<separator/>
<n:table xmlns:n="native">
    <n:tr>
        <n:td n:colspan="2">Visible row</n:td>      
    </n:tr>
    <n:tr if="false">
        <n:td>Name</n:td>
        <n:td>
            <textbox value="Invisible"/>
        </n:td>
    </n:tr>
</n:table></zk>`,
	);
	await t
		.expect(
			await ClientFunction(() => !!jq("td:contains(Visible row)")[0])(),
		)
		.ok("You should only see 'Visible row' below this line.");
	await t
		.expect(await ClientFunction(() => !!jq(".z-textbox")[0])())
		.notOk("You should only see 'Visible row' below this line.");
});
