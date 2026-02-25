import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1948963TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1948963TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<n:ol>
		<n:li>Type a time into the Timebox, then click the button, then you should not see any error box.</n:li>
	</n:ol>
	<window title="My First Window" border="normal" width="200px">
	<timebox id="time"/>
	<button label="validate" onClick="validate()"/>
	<zscript>
	void validate()
	{
	if(time.getValue() == null)
		throw new WrongValueException(time, &quot;Empty&quot;);
	}
	</zscript>
	</window>
</zk>`,
	);
	await ClientFunction(() => {
		zk.Widget.$(jq("@timebox")).$n("real").focus();
	})();
	await t.click(Selector(() => zk.Widget.$(jq("@timebox")).$n("btn-up")));
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
});
