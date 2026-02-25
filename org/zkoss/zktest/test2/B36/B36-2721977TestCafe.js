import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2721977TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2721977TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			1.Press the button "save" twice or thrice, you should always see the two error box.
			<window title="My First Window" border="normal" width="200px">
			    <vlayout>
			    <textbox id="txb1"/>
			    <textbox id="txb2"/>
			    </vlayout>
			    <button id="btn" label="save" onClick="save()"/>
			    <zscript>
			        public void save() {
			            ArrayList al = new ArrayList();
						try{
				            if(txb1.getValue() == null || txb1.getValue().length() == 0) {
				                 al.add(new WrongValueException(txb1, "fill textbox 1"));
				                 txb1.focus();
				            }
				            if(txb2.getValue() == null || txb1.getValue().length() == 0)
				                 al.add(new WrongValueException(txb2, "fill textbox 2"));
			        	}catch(Exception e) {
			        		if(al.isEmpty())
			            		throw e;
			        	}
			            if(al.size() > 0)
			                throw new WrongValuesException(al.toArray(new WrongValueException[1]));
					}
			    </zscript>
			</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});
