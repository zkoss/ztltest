import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2480892TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2480892TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<zscript>
				String[] values = new String[] {"Red", "Blue", "Purple"};
				</zscript>
			
			You shall see three textbox components below. The value of them shall be
			Red, Blue and Purple, respectively.
			
			<ol xmlns="http://www.zkoss.org/2005/zk/native"
			xmlns:u="http://www.zkoss.org/2005/zul">
				<li forEach="\${values}"><u:textbox value="\${each}"/></li>
			</ol>	
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox:eq(0)").val())(),
			),
		)
		.eql(ztl.normalizeText("Red"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox:eq(1)").val())(),
			),
		)
		.eql(ztl.normalizeText("Blue"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("Purple"));
});
