import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1662TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1662TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. Move Window C to center.
	2. Overlap Window B on Window C partially.
	Expected: Window B should be the topmost window.
	</label>
	<window sizable="true" mode="overlapped" border="normal" title="Window A" closable="true">
		<label value="Hello World"/>
	</window>
	<window sizable="true" mode="overlapped" border="normal" title="Window B" closable="true">
		<label value="Hello World"/>
	</window>
	<window sizable="true" mode="overlapped" border="normal" title="Window C" closable="true">
		<label value="Hello World"/>
	</window>
</zk>`,
	);
	await t
		.drag(
			Selector(() =>
				zk.Widget.$(jq(".z-window-overlapped:contains(C)")).$n("cap"),
			),
			190,
			190,
			{ offsetX: 10, offsetY: 10 },
		)
		.drag(
			Selector(() =>
				zk.Widget.$(jq(".z-window-overlapped:contains(B)")).$n("cap"),
			),
			190,
			190,
			{ offsetX: 10, offsetY: 10 },
		);
	let b_Zinx_cafe = await ClientFunction(() =>
		jq(".z-window-overlapped:contains(B)").css("z-index"),
	)();
	let c_Zinx_cafe = await ClientFunction(() =>
		jq(".z-window-overlapped:contains(C)").css("z-index"),
	)();
	await t
		.expect(b_Zinx_cafe > c_Zinx_cafe)
		.ok("Window B should be the topmost window.");
});
