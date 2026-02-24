import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1990423TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1990423TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
    			<window title="toolbar demo" border="normal" width="300px" id="win">
    				Each button works well.
    				<button label="has border" onClick=\'win.border = "normal"\'/>
    				<button label="none border" onClick=\'win.border = "none"\'/>
    			</window>
    		</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	let br1_cafe = await ClientFunction(() =>
		zk.Widget.$(jq("@window:eq(0)")).getBorder(),
	)();
	await t.expect(ztl.normalizeText("none")).eql(ztl.normalizeText(br1_cafe));
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let br_cafe = await ClientFunction(() =>
		zk.Widget.$(jq("@window:eq(0)")).getBorder(),
	)();
	await t.expect(ztl.normalizeText("normal")).eql(ztl.normalizeText(br_cafe));
});
