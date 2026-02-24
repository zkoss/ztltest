import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1920751TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1920751TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Please type the word "s" into the input element, and then press the "Down" button, and the item "Cool!" should be shown.</n:p>
				<combobox id="cb1" constraint="strict">
					<comboitem label="Simple and Rich" disabled="true"/>
					<comboitem label="Cool!"/>
					<comboitem label="Thumbs Up!" disabled="true"/>
					<comboitem label="ZK Best!"/>
					<comboitem label="ZK Best1 ! " disabled="true"/>
				</combobox>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb1", true).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Cool!"));
});
