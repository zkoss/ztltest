import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1822727TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1822727TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="listbox checkmark demo" border="normal">
<html><![CDATA[
The selection of listbox is not correct when use toggle multiple.<br/>
reproducible step.<br/>
1.select Henry and Dennis<br/>
2.click toogle multiple ,<br/>
3.click toogle multiple again.<br/>
4.Disselect Henry.<br/>
5.Click invalidate.<br/>
<br/>
Henry should <b>NOT</b> be selected.<br/>
<br/>
]]></html>
	<button id="btn1" label="Toggle multiple" onClick="box.multiple = !box.multiple"/>
	<button id="btn2" label="Invalidate" onClick="box.invalidate()"/>
	<separator bar="true"/>
	<listbox id="box" width="460px" multiple="true" checkmark="true">
		<listhead>
			<listheader label="Name"/>
			<listheader label="Gender"/>
			<listheader label="Age"/>
			<listheader label="Description"/>
		</listhead>
		<listitem>
			<listcell label="Mary"/>
			<listcell label="FEMALE"/>
			<listcell label="18"/>
			<listcell label="A young lady."/>
		</listitem>
		<listitem>
			<listcell label="John"/>
			<listcell label="MALE"/>
			<listcell label="20"/>
			<listcell label="A college student."/>
		</listitem>
		<listitem>
			<listcell label="Jane"/>
			<listcell label="FEMALE"/>
			<listcell label="32"/>
			<listcell label="A remarkable artist."/>
		</listitem>
		<listitem id="li1">
			<listcell label="Henry"/>
			<listcell label="MALE"/>
			<listcell label="29"/>
			<listcell label="A graduate."/>
		</listitem>
		<listitem id="li2">
			<listcell label="Dennis"/>
			<listcell label="MALE"/>
			<listcell label="30"/>
			<listcell label="A developer"/>
		</listitem>
	</listbox>		
</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("li1", true).$n("cm")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("li2", true).$n("cm")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("li1", true).isSelected(),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("li2", true).isSelected(),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("li1", true).$n("cm")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("li1", true).isSelected(),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("li1", true).isSelected(),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("li2", true).isSelected(),
			)(),
		)
		.notOk();
});
