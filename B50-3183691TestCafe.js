import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3183691TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3183691TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
			<ul>
			  <li>Click the click button and you shall see a listbox being open and dropped</li>
			</ul>
			]]></html>
			
			<button id="btn" label="click" xmlns:w="client" w:onClick="var lb = zk.Widget.$(jq(\'@listbox\'));lb.fire(\'onSelect\');lb.fire(\'onSelect\');"/>
			<listbox width="200px">
			<attribute name="onSelect"><![CDATA[
			div.getChildren().clear();
			Executions.createComponentsDirectly(
			"<combobox id=\\"cb\\" open=\\"true\\"><comboitem label=\\"item\\" forEach=\\"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1\\"/></combobox>",
			"zul",div,null);
			]]></attribute>
			<listitem label="item"/>
			<listitem label="item"/>
			</listbox>
			<div id="div" />
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.expect("true").ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("cb", true).$n("pp").style.display,
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
});
