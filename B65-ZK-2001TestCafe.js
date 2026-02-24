import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-2001TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-2001TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div>click chosenbox, then the listitem should not be selected</div>
	<listbox width="500px">
		<listhead>
			<listheader label="col" />
			<listheader label="col" />
			<listheader label="col" />
		</listhead>
		<listitem forEach="1,2">
			<listcell label="Item \${each}" />
			<listcell>
				<textbox />
			</listcell>
			<listcell>
				<chosenbox width="100px" />
			</listcell>
		</listitem>
	</listbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-chosenbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-listitem-selected")[0])())
		.notOk("the listitem should not be selected");
});
