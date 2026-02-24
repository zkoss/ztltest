import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2468048TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2468048TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[  
				<ol>
				<li>You shall see three windows: A window, B window, and C window.</li>
				<li>C window is inside A window</li>
				<li>Press \'show variable x\' button inside C window. You shall see popup "A".</li>
				<li>Press \'Move C window with div wrapper from A to B\' button.</li>
				<li>You shall see C window is moved to be inside B window.</li>
				<li>Now press \'show variable x\' button inside C window again. You shall see popup "B".</li>
				<li>Done</li> 
				</ol>
				]]></html>
				
				<window id="levelA" title="A window" width="500px" border="normal">
				 <custom-attributes x="A"/>
				 <div id="levelC_wrapper">
				 Following is C Window :
				  <window id="levelC" title="C window" width="400px" border="normal">
				   <button id="btn" label="show variable x" onClick=\'alert(self.getAttribute("x", true))\'/>
				  </window>
				 </div>
				</window>
				
				<space spacing="50px" bar="true"/>
				
				<window id="levelB" title="B window" width="500px" border="normal">
				 <variables x="B"/>
				</window>
				
				<space spacing="50px" bar="true"/>
				
				<div>
				<button label="Move C window with div wrapper from A to B">
				 <attribute name="onClick">
				  Component c = Path.getComponent("/levelA/levelC_wrapper");
				   c.setParent(levelB);
				  </attribute>
				</button>
				</div>
				
				</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
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
		.eql(ztl.normalizeText("A"));
	await t.click(Selector(() => jq(".z-messagebox-window @button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button.z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
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
		.eql(ztl.normalizeText("B"));
});
