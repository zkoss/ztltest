import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2150566TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2150566TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<listbox width="200px">
<listgroup label="Listgroup" id="lg"/>
<listitem label="Listitem"/>
</listbox>
<button label="After click me, and then click the \'open/close\' icon should be open/close well"
onClick=\'lg.label="test"\'/>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem @listcell").is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Widget.$(jq("@listgroup")).$n("img")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem @listcell").is(":visible"),
			)(),
		)
		.notOk();
});
