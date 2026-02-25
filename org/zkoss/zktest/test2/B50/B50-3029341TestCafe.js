import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3029341TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3029341TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html>
<![CDATA[
<ol>
	<li>Click "a link"</li>
	<li>Check the row of the listbox will not be selected</li>
</ol>
]]>
</html>
	<listbox width="300px">
		<listitem>
			<listcell>
				<a label="a link" />
			</listcell>
			<listcell>
				<button label="button" />
			</listcell>
		</listitem>
		<listitem label="second item" />
	</listbox>
</zk>`,
	);
	await t.click(Selector(() => jq("@a")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq("@listitem:eq(1)").is("selected"))(),
		)
		.notOk();
	await t
		.expect(await ClientFunction(() => !!jq(".z-listitem-selected")[0])())
		.notOk();
});
