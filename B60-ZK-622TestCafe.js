import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-622TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-622TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="w" mode="modal" xmlns:n="http://www.zkoss.org/2005/zk/native" width="500px">
				<n:p>Please click the "female" radio, and then click the "show" button, and then you should see that only "female" is checked and the label "undefined" is shown</n:p>
				<radiogroup id="radiochoice">
					<radio id="male1" label="male" checked="true" />
					<radio id="female" label="female" />
				</radiogroup>
				 <button id="btn" label="show" xmlns:w="client" w:onClick=\'this.$f("log").setValue(jq("$male1 input").attr("checked")+"");\'/>
				 <label id="log"/>
			</window>`,
	);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("female", true).$n("real")))
		.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("male1", true).$n("real").checked,
				)(),
			),
		)
		.eql(ztl.normalizeText("false"), "mail should not be checked");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("log", true).$n().innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("undefined"), "label 'undefined' is shown");
});
