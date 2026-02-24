import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2433176TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2433176TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="window">
				Please click the "Bind" button, and then check a radio box, you should see a dialog as its label
			    <radiogroup id="rb" onCheck=\'alert(self.selectedItem.label);\'/>
			    <button id="save" label="Bind" width="70px" >
			    	<attribute name="onClick"><![CDATA[ 
			    		Vbox vb = new Vbox();
			    		for (int i =0; i < 5; i++) {
			    			new Radio("Radio " + i).setParent(vb);
			    		}
			    		vb.setParent(rb);
			    		 ]]></attribute>
			    </button>
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("save", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-radio input:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox > span.z-label:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Radio 0"));
	await t.click(Selector(() => jq("@button.z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-radio input:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox > span.z-label:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Radio 1"));
	await t.click(Selector(() => jq("@button.z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-radio input:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox > span.z-label:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Radio 2"));
	await t.click(Selector(() => jq("@button.z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-radio input:eq(3)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox > span.z-label:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Radio 3"));
	await t.click(Selector(() => jq("@button.z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-radio input:eq(4)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox > span.z-label:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Radio 4"));
	await t.click(Selector(() => jq("@button.z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
});
