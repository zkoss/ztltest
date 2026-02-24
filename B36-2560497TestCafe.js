import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2560497TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2560497TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<vbox>
				Click the first button and click the second button.
				Then click the datebox popup.
				<separator />
				
				you should not see any error message
				
			</vbox>
			<datebox id="DTbox" />
			<button id="b1" label="hh:mm">
				<attribute name="onClick"><![CDATA[
				DTbox.setFormat("hh:mm");
			]]></attribute>
			</button>
			<button id="b2" label="ddMMyy">
				<attribute name="onClick"><![CDATA[
				DTbox.setFormat("ddMMyy");
			]]></attribute>
			</button>
		</zk>`,
	);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("b1", true).$n()))
		.click(Selector(() => zk.Desktop._dt.$f("b2", true).$n()))
		.click(Selector(() => zk.Desktop._dt.$f("DTbox", true).$n("btn")));
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
