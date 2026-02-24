import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1914230TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1914230TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Memory Leak Test">
			<vbox>
				<html><![CDATA[
				<ol>
					<li>Input invalid value in the combobox, e.g., xxx.</li>
					<li>Press TAB to change focus.</li>
					<li>An erorr massage is shown up, but no onSelect is fired.</li>
				</ol>
				In other words, if the client detects the error, it shall not notify
				the server (with onSelect).
				]]></html>
				
				<combobox id="cb" constraint="strict"
					onSelect=\'msg1.value = "onSelect is fired, " + (self.selectedItem != null ? self.selectedItem.label:"n/a")\'
					onChange=\'msg2.value = "onChange is fired, " + self.value\'>
					<comboitem label="aaa" value="1" />
					<comboitem label="bbb" value="2" />
				</combobox>
				<label id="msg1"/>
				<label id="msg2"/>
				<button label="reset message" onClick=\'msg1.value = msg2.value = ""\'/>
				<button label="reset all" onClick=\'cb.value = msg1.value = msg2.value = ""\' />
			</vbox>
		</window>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("cb", true).$n("real").focus();
	})();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("cb", true).$n("real")),
		ztl.normalizeText("xxx"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("msg1", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("msg2", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});
