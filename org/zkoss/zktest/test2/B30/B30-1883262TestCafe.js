import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1883262TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1883262TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
<n:p>1.Please focus in and out the input element, you should not see any error dialog.</n:p>
<n:p>2.The textbox shall disappear.</n:p>

	<window id="win">	 
	<zscript><![CDATA[
Constraint ctt = new Constraint() {
	public void validate(Component comp, Object value) throws WrongValueException { 
		try {
			throw new WrongValueException( comp, "Error" );
		}finally{
			Events.postEvent(new Event("onChange", comp, null));
		}
	} 
} 
	]]></zscript>
	<button id="blur" label="blur"/>
	<textbox id="txtbox" constraint="\${ctt}" onChange="self.clearErrorMessage();win.detach();"/>
	</window>
</zk>`,
	);
	await ClientFunction(() => {
		zk.Widget.$(jq("$txtbox")).$n().focus();
	})();
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-textbox")[0])()).notOk();
});
