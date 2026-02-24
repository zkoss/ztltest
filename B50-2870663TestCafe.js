import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2870663TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2870663TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
			<html><![CDATA[
			<p>No value doublebox/decimalbox shall show empty; NOT \'null\'.
			<ol>
			<li>You shall see two input box. 1st is a doublebox. 2nd is a decimalbox.</li>
			<li>If you see nothing inside the two input boxes, then it is OK. Otherwise, it is a bug.</li>
			</ol>
			]]></html>
			<hbox>doublebox: <doublebox/></hbox>
			<hbox>decimalbox: <decimalbox/></hbox>
			</vbox>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(jq("@doublebox")).val())(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(jq("@decimalbox")).val())(),
			),
		)
		.eql(ztl.normalizeText(""));
});
