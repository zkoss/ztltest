import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3190542TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3190542TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click Maximize icon. the panel will become lagger.</li>
			<li>Click restore icon. that shall not error happen.</li>
		</ol>
	]]></html>
	<portallayout id="pl" maximizedMode="whole">
		<portalchildren >
			<panel height="150px" title="panel" border="normal" 
				maximizable="true" onMaximize="">
				<panelchildren>
				</panelchildren>
			</panel>
		</portalchildren>
	</portallayout>
</zk>`,
	);
	let screenwidth_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("pl", true).$n().parentNode).width(),
	)();
	let x_cafe = await ClientFunction(() => jq("@panel").width())();
	await t.click(Selector(() => jq(".z-panel-icon")[0]));
	await ztl.waitResponse(t);
	let x1_cafe = await ClientFunction(() => jq("@panel").width())();
	await t.expect(x1_cafe > x_cafe).ok();
	await t.expect(screenwidth_cafe < x1_cafe + 10).ok();
	await t.click(Selector(() => jq(".z-panel-icon")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
});
