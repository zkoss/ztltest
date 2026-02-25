import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1823357TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1823357TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
				[ 1823357 ] auxHeader(IE)- Can not change rowspan dynamically</br>
				]]></html>
					<tree id="tree2" width="240px">
						<treecols>
							<treecol label="A" />
							<treecol label="B" />
							<treecol label="C" />
						</treecols>
						<auxhead>
							<auxheader id="Phi" label="Phi"  colspan="2" />
						</auxhead>
					</tree>
					<button label="test" onClick="Phi.setColspan(3)" />
				</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("Phi", true)).attr("colspan"),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
});
