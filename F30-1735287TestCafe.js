import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F30-1735287TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F30-1735287TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:h2>[ 1735287 ] Disable Toolbarbutton</n:h2>
			<n:ol>
				<n:li>Click the button1 and button3(gray link), then you should not see any dialog.</n:li>
				<n:li>Click the enable btn1 and enable btn3, now you can click button1 and button3 showing alert message.</n:li>
			</n:ol>
			<window title="Disable Toolbarbutton" border="normal" width="300px">
				<caption>
					<toolbarbutton id="btn3" disabled="true" label="button3" onClick=\'alert("You should not see this dialog!");\'/>
					<toolbarbutton id="en3" label="enable btn3" onClick="btn3.disabled=false"/>
				</caption>
				<toolbar>
					<toolbarbutton id="btn1" disabled="true" label="button1" onClick=\'alert("You should not see this dialog!");\'/>
					<toolbarbutton id="en1" label="enable btn1" onClick="btn1.disabled=false"/>
				</toolbar>
			</window>
		</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("en1", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.ok();
	await t.click(Selector(() => jq(".z-messagebox-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("en3", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-window")[0])())
		.ok();
});
