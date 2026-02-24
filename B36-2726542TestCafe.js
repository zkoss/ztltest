import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2726542TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2726542TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
				<div id="outer" style="overflow-y: scroll; height: 200px;">
				<button label="test" w:onClick=\'this.$f("outer").$n().scrollTop=200;jq(this.$f("l1")).val(zk(this.$f("outer")).revisedOffset()[1]);\'/>
				<div style="height: 800px;background:red;"/> </div>
				<label id="l1"/>
				After click the test button, you should see the message "top, 0".
			</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("l1", true)).val(),
				)(),
			),
		)
		.contains(ztl.normalizeText("0"), "");
});
