import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2936019TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2936019TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html><![CDATA[
<ol>
<li>Press the "add Group+Groupfoot" button</li>
<li>If you see a Group and a Groupfoot item shown in the listbox, then it is OK; otherwise, it is a bug</li>
</ol>
]]>
</html>
<listbox id="lbx" mold="paging">
	<listhead>
		<listheader label="header"></listheader>
	</listhead>
</listbox>
<zscript>
	lbx.getPaginal().setAutohide(false);
</zscript>
<button label="add Group+Groupfoot">
	<attribute name="onClick">
	<![CDATA[
	Listgroup lg = new Listgroup("Group");
	lbx.insertBefore(lg, lbx.getPaginal());
	Listgroupfoot lgf = new Listgroupfoot("Groupfoot");
	lbx.insertBefore(lgf, lbx.getPaginal());
	]]>
	</attribute>
</button>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-listgroup").is(":visible"))())
		.ok();
	await t
		.expect(
			await ClientFunction(() => jq(".z-listgroupfoot").is(":visible"))(),
		)
		.ok();
});
