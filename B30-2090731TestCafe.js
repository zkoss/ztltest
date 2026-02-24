import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2090731TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2090731TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Click the change button, and the image of the button shall change.
	Then, click the reset button, and the image shall change back.
	<separator/>
	<button id="b" label="Left" image="/test2/img/m1.gif" width="125px"/>
	<separator/>
	<zscript>
	import org.zkoss.image.*;
	</zscript>
	<button label="change"
		onClick=\'b.setImageContent(new AImage("t", desktop.webApp.getResourceAsStream("/test2/img/folder.gif")))\'/>
	<button label="reset" 
		onClick=\'b.setImage("/test2/img/m1.gif"); \'/>
</zk>`,
	);
	let ori_cafe = await ClientFunction(() =>
		jq("@button:eq(0) img").attr("src"),
	)();
	await t.click(Selector(() => jq('@button[label="change"]')[0]));
	await ztl.waitResponse(t);
	let aft_cafe = await ClientFunction(() =>
		jq("@button:eq(0) img").attr("src"),
	)();
	await t
		.expect(ztl.normalizeText(aft_cafe))
		.notEql(ztl.normalizeText(ori_cafe), "");
	await t.click(Selector(() => jq('@button[label="reset"]')[0]));
	await ztl.waitResponse(t);
	let ori1_cafe = await ClientFunction(() =>
		jq("@button:eq(0) img").attr("src"),
	)();
	await t
		.expect(ztl.normalizeText(ori1_cafe))
		.eql(ztl.normalizeText(ori_cafe));
});
