import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1806152TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1806152TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html><![CDATA[
In IE, if model size is zero (start from zero or after clear)
then when add new one in to model, the listbox will miss the onRender au
event which should send to server,
but it is work in FF.<br/>
<br/>
]]></html>
<button id="btn" label="add" onClick="add()" />
<listbox id="lb"/>
<zscript>
ListModelList model = new ListModelList();
//model.add("Item 1");
lb.setModel(model);
public void add(){
if(model.size()>10){
model.clear();
}else{
model.add(">>Item Y :"+new java.util.Date());
}
}
</zscript>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("lb", true).firstChild.getLabel(),
				)(),
			),
		)
		.contains(ztl.normalizeText(">>Item Y :"), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("lb", true).lastChild.getLabel(),
				)(),
			),
		)
		.contains(ztl.normalizeText(">>Item Y :"), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true)).outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 15 * 3).ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:odd").hasClass("z-listbox-odd"),
			)(),
		)
		.ok();
});
