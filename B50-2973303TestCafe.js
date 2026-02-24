import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2973303TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2973303TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
				<ul>
				<li>You see see nothing shown in the following listbox</li>
				</ul>
			]]></html>
			<listbox id="listbox" mold="select" rows="1">
			<listitem label="A" />
			<listitem label="B" />
			<listitem label="C" />
			</listbox>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("listbox", true).$n().value,
				)(),
			),
		);
});
