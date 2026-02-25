import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2241309TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2241309TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="myWindow" title="My First Window" border="normal" width="500px">
			<html><![CDATA[
			<ol>
			<li>You shall see two buttons "Ok" and "Ok2".</li>
			<li>Press "Ok2" button, and you shall see the "Ok2" changed to "NewLabel".</li>
			<li>Done</li>
			</ol>
			]]></html>
				<button id="btn1" label="Ok" apply="org.zkoss.zktest.test2.B2241309Composer"/>
				<zscript><![CDATA[
					Button btn2 = btn1.clone();
					btn2.setId("btn2");
					btn2.setLabel("Ok2");
					btn2.setParent(myWindow);
				]]></zscript>
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-button:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("NewLabel"));
});
