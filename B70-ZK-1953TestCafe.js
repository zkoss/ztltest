import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-1953TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-1953TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="Checkmark Listhead Listbox" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Checkmark Listhead Listbox" border="normal">
		<label value="Listhead\'s checkmark should be invisible "/>
		<div>
		    <listbox width="300px" checkmark="true" multiple="true">
		        <listhead>
		            <listheader>
		                <label value="Can an empty list be all selected?"/>
		            </listheader>
		        </listhead>
		    </listbox>
		</div>
	</window>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-listheader-checked")[0])())
		.notOk("Listhead's checkmark should be invisible");
});
