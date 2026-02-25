import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2948454TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2948454TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
	<ol>
		<li>Click "move button"</li>
		<li>Then, click "test" and you shall see the "success: target" message</li>
	</ol>
	]]></html>
 <zscript><![CDATA[
  move() {
	Div div = new Div();
	div.appendChild(win);
	cave.appendChild(div);
  }
]]></zscript>
 <button label="move button" onClick="move()"/>
 <window id="cave" border="normal">
 	<label id="inf" value="target"/>
 </window>

 <window id="win">
  <zscript>
  //nothing but force it to be evaluated
  </zscript>
  <button label="click" onClick=\'alert("success:" + inf.value)\' />
 </window>
</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="move button"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="click"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox .z-label").html(),
				)(),
			),
		)
		.eql(ztl.normalizeText("success:target"));
});
