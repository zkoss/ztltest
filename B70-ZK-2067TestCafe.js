import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2067TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2067TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="wd" border="normal" width="400px" title="Popup in Overlapping and Modaling Window">
	<tree onClick="wd.doOverlapped();wd.doModal();">
			<treecols>
				<treecol/>
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Click me should not show any error." popup="pp"/>
					</treerow>
				</treeitem>
			</treechildren>
	</tree>
	<popup id="pp">
		<label value="Popup"/>
	</popup>
</window>`,
	);
	await t.click(Selector(() => jq(".z-treecell")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
