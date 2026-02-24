import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3284663TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3284663TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click on the Radio. The messagebox should NOT be shown. Otherwise it is a bug.</li>
			<li>Click on the Button. A messagebox should popup. Otherwise it is a bug.</li>
		</ol>
	]]></html>
	<zscript><![CDATA[
		import org.zkoss.zk.au.*;
		AuService as = new AuService() {
			public boolean service(AuRequest request, boolean everError) {
				if("onCheck".equals(request.getCommand()))
					Messagebox.show("AuService: onCheck");
				return false;
			}
		};
	]]></zscript>
	<radiogroup>
		<radio id="r1" label="A" checked="false" auService="\${as}" />
	</radiogroup>
	<button label="Save" onClick="" />
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("r1", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => !!jq('@window[title="ZK Test"]')[0])(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@window[title="ZK Test"] @label')
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("AuService: onCheck"));
});
