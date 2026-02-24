import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-359TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-359TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test" mode="modal" border="normal" width="80%">
				<html><![CDATA[
				<ol>
				<li>Check the first listbox. No item shall be selected (i.e., it shall be empty).</li>
				<li>Click embed and check the first listbox. No item shall be selected.</li>
				<li>Click modal and check again.</li>
				<li>Click the drop down of the bandbox. It will slide down and the listbox shown shall has no item being selected.</li>
				</ol>
				]]></html>
			
				<listbox id="lb1" rows="1" mold="select" w:onSelect="zk.log(this)" xmlns:w="client">
				<listitem label="Test"/>
				</listbox>
				<button id="btn1" label="embed" onClick="self.parent.doEmbedded()"/>
				<button id="btn2" label="modal" onClick="self.parent.doModal()"/>
				<bandbox id="bb">
					<bandpopup>
					<listbox id="lb2" rows="1" mold="select" w:onSelect="zk.log(this)" xmlns:w="client">
					<listitem label="Test"/>
					</listbox>
					</bandpopup>
				</bandbox>
			</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1", true).$n().value,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1", true).$n().value,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1", true).$n().value,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Desktop._dt.$f("bb", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2", true).$n().value,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});
