import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3021174TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3021174TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
   <html><![CDATA[
	<ul>
	<li>Click "show popup window" shall not cause js error</li>
	</ul>
	]]></html>
	<button id="btn" label="click" >
		<attribute name="onClick"><![CDATA[
			createEvent.setLeft("100px");
			createEvent.visible = true;
		]]></attribute>
	</button>
	<window width="400px" title="Create Event" border="normal"
			id="createEvent" mode="popup" visible="false"  closable="true"/>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
