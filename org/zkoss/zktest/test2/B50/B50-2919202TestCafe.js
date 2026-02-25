import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2919202TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2919202TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
				<html><![CDATA[
				Test listbox + constraint:
				<ul>
					<li>Click show, then an error box shall be shown beside the listbox</li>
					<li>Click close, then the box shall disappear</li>
					<li>Click show again, and click toggle several times to see if
					the box shows and disappears with the listbox</li>
				</ul>
				]]></html>
				<listbox id="mylistbox" rows="1" mold="select">
				<listitem label="Inbox"/>
				<listitem label="Received"/>
				<listitem label="Draft"/>
				</listbox>
				<button id="show" label="show" onClick=\'throw new WrongValueException(mylistbox,
				"error")\'/>
				<button id="close" label="close" onClick="Clients.clearWrongValue(mylistbox)"/>
				<button id="toggle" label="toggle" onClick="mylistbox.visible = !mylistbox.visible"/>
				</vbox>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq("@select > option ")[0])())
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("show", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("close", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("show", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("toggle", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("close", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await t
		.expect(await ClientFunction(() => jq(jq("@select")).is(":visible"))())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("toggle", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(jq("@select")).is(":visible"))())
		.ok();
});
