import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1984025TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1984025TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test" border="normal">
	You should see the "Ready" footer in this demo.
<listbox width="250px" height="400px">
<listhead sizable="true">
<listheader label="name" sort="auto"/>
<listheader label="gender" sort="auto"/>
</listhead>
<listitem>
<listcell label="Mary"/>
<listcell label="FEMALE"/>
</listitem>
<listitem>
<listcell label="John"/>
<listcell label="MALE"/>
</listitem>
<listitem>
<listcell label="Jane"/>
<listcell label="FEMALE"/>
</listitem>
<listitem>
<listcell label="Henry"/>
<listcell label="MALE"/>
</listitem><listfoot>
<listfooter label="Ready" />
</listfoot>
</listbox>
</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listfooter:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Ready"));
});
