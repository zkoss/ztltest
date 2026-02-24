import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1899003TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1899003TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
    			<html><![CDATA[
    				Test Environment: IE6<br/>
    				Expected Result: you shall see a blue line between abc and xyz
    			]]></html>
    			<vbox width="100%">
    				<label value="abc" />
    				<label value="xyz" />
    				</vbox>
    					<style>
    						tr.z-vbox-separator td {border-bottom: 1px solid blue}
    					</style>
    		</window>`,
	);
	await t.expect(ztl.normalizeText("abc")).eql(
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-vbox")).$n("real"))
					.find("tr:eq(1)")
					.prev()
					.text()
					.replace(/\s/g, " "),
			)(),
		),
	);
	await t.expect(ztl.normalizeText("xyz")).eql(
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-vbox")).$n("real"))
					.find("tr:eq(1)")
					.next()
					.text()
					.replace(/\s/g, " "),
			)(),
		),
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-vbox")).$n("real"))
					.find("tr:eq(1)")
					.hasClass("z-vbox-separator"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("blue"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(
							jq(zk.Widget.$(jq(".z-vbox")).$n("real")).find(
								"tr:eq(1)",
							),
						)
							.find("td")
							.css("border-bottom-color"),
					)(),
				),
			),
		)
		.ok();
});
