import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2448099TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2448099TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="win" title="My First Window" border="normal" width="400px">
<html>
<![CDATA[
<ol>
<li>FireFox only</li>
<li>Press "add onXyz&#36;Abc event listener" button.</li>
<li>You shall see nothing happened. Otherwise, it is a bug.</li>
<li>Done</li>
</ol>
]]>
</html>
<button label="add onXyz$Abc event listener">
<attribute name="onClick"><![CDATA[
win.addEventListener("onXyz$Abc", new EventListener() {
public void onEvent(Event evt) {
//do nothing
}
});
]]></attribute>
</button>
</window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
