import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1943783TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1943783TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Press \'Enter\' key and you will see a messagebox is shown.
Press \'ESC\' key and you will see a messagebox is shown.
<separator/>
<timebox onOK=\'alert("OK:"+self.value)\' onCancel=\'alert("ESC:"+self.value)\' focus="true"/>
<separator/>
<textbox onOK=\'alert("OK:"+self.value)\' onCancel=\'alert("ESC:"+self.value)\'/>
<separator/>
<datebox onOK=\'alert("OK:"+self.value)\' onCancel=\'alert("ESC:"+self.value)\'/>
</zk>`,
	);
	await t.pressKey("enter");
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
		.notEql(ztl.normalizeText("OK:null"), "");
	await t.click(Selector(() => jq('@window[title="ZK Test"] @button')[0]));
	await ztl.waitResponse(t);
	await t.pressKey("esc");
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
		.notEql(ztl.normalizeText("ESC:null"), "");
});
