import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1943594TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1943594TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window border="none" width="100%" xmlns="http://www.zkoss.org/2005/zul">
				<html><![CDATA[
				<ul>
				<li>
				Click dropdown and select an item. A exception dialog shall show up.
				Click OK to close the  dialog. Then, the dialog shall <b>NOT</b> re-appear again.</li>
				<li>Click combobox\'s dropdown button, then click other place of this page.
				A exception dialog shall show up.Click OK to close the dialog. Then, the dialog shall <b>not</b>
				re-appear again.</li>
				</ul>
				]]></html>
				<a label=" "/>
				<zscript><![CDATA[
					public class MyCombo extends Combobox implements EventListener{
						public MyCombo () {
							addEventListener("onBlur", this);
						}
						public void onEvent(Event event) throws Exception {
							if ("onBlur".equals(event.getName())) {
								throw new java.io.NotSerializableException();
							}
						}
					}
					public class MyDate extends Datebox implements EventListener{
						public MyDate () {
							addEventListener("onBlur", this);
						}
						public void onEvent(Event event) throws Exception {
							if ("onBlur".equals(event.getName())) {
								throw new java.io.NotSerializableException();
							}
						}
					}
				]]></zscript>
				<combobox autodrop="true" use="MyCombo">
					<comboitem label="Value 1"/>
					<comboitem label="Value 2"/>
					<comboitem label="Value 3"/>
					<comboitem label="Value 4"/>
					<comboitem label="Value 5"/>
				</combobox>
				<label id="a" value="test"/>
				<datebox use="MyDate"/>
			</window>`,
	);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@comboitem:eq(0)")[0])).wait(1000);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$a")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-messagebox")[0])()).ok();
	await t.click(
		Selector(() => jq("@button")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox")[0])())
		.notOk();
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-datebox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$a")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-messagebox")[0])()).ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox")[0])())
		.notOk();
});
