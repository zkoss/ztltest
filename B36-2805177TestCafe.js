import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2805177TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2805177TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<div><label style=\'font-size:20px;\' value="You should see the two headers only, no body\'s height are displayed (IE only)"/> </div>
			
			<listbox>
			<listhead>
			<listheader label=\'column 1\'/>
			<listheader label=\'column 2\'/>
			<listheader label=\'column 3\'/>
			<listheader label=\'column 4\'/>
			<listheader label=\'column 5\'/>
			</listhead>
			</listbox>
			
			<separator/>
			
			<grid>
			<columns>
			<column label=\'column 1\'/>
			<column label=\'column 2\'/>
			<column label=\'column 3\'/>
			<column label=\'column 4\'/>
			<column label=\'column 5\'/>
			</columns>
			<rows>
			</rows>
			</grid>
			</zk>`,
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("div.z-listbox-body").outerHeight(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("0"),
		ztl.normalizeText(
			await ClientFunction(() => jq("div.z-grid-body").outerHeight())(),
		),
		ztl.normalizeText("1"),
	);
});
