import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2449TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2449TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
		The bottom two buttons should display in the same line. (the upload and normal)
	</label>
	<div style="border: 1px solid green">
		<button label="normal1"/>
		<button label="normal2"/>
	</div>

	<div style="border: 1px solid red">
		<button label="upload" upload="true" onUpload="Clients.showNotification(event.getMedia().getName())" />
		<button label="normal"/>
	</div>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-div").first().outerHeight(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-div").last().outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_0_0 == verifyVariable_cafe_1_1).ok();
});
