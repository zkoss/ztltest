import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-1826TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-1826TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div>
		Resize the window and then click the button, the width and height should
		not change.
	</div>
	<window id="win" title="orig" border="normal" mode="overlapped"
		sizable="true" width="200px">
		<button style="float:right" label="set title to ZK" onClick=\'win.setTitle("ZK");\' />
	</window>
</zk>`,
	);
	await t.drag(
		Selector(() => jq(".z-window")[0]),
		0,
		2,
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	let h_cafe = await ClientFunction(() => jq(".z-window").height())();
	let w_cafe = await ClientFunction(() => jq(".z-window").width())();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-window").height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-window").width(),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 == h_cafe &&
				verifyVariable_cafe_1_1 == w_cafe,
		)
		.ok("the width and height should not change.");
});
