import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1527TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1527TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	Chrome/Safari Only
	1. Open datebox\'s popup.
	2. Click arrow button of the timebox directly (do not focus on input node), should see the value in datebox changed.
	</label>
	<datebox id="db" cols="20" format="yyyy/MM/dd HH:mm" onCreate="self.value = new Date()" />
</zk>`,
	);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-datebox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	let before_cafe = await ClientFunction(
		() => zk.Widget.$(jq(".z-timebox")).$n("real").value,
	)();
	await t.click(Selector(() => zk.Widget.$(jq(".z-timebox")).$n("btn-down")));
	await ztl.waitResponse(t);
	let after_cafe = await ClientFunction(
		() => zk.Widget.$(jq(".z-timebox")).$n("real").value,
	)();
	await t
		.expect(ztl.normalizeText(after_cafe))
		.notEql(
			ztl.normalizeText(before_cafe),
			"should see the value in datebox changed",
		);
});
