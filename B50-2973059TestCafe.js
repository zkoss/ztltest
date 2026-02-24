import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2973059TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2973059TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
			<ul>
			 <li>Type "abc" in the text box and click the button</li>
			 <li>Then, you shall see a message showing up with "abc"</li>
			</ul>
			]]></html>
			
			<textbox id="mytextbox" value="" width="240px" />
			<button id="btn" label="xxx" image="/img/inet.png" onClick="alert(mytextbox.getValue())"
			mold="default"/>
			
			</zk>`,
	);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("mytextbox", true).$n()),
		ztl.normalizeText("abc"),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@window[title="ZK Test"] @label')
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("abc"));
});
