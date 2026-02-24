import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2928109TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2928109TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await ztl.runZscript(
		t,
		`<zk>
					If you see in the "my window" the content sentence "my window is here" is in
					the same line then it is OK; otherwise if the "here" is wrapped to the 2nd
					line because window is too narrow, it is bug.
					<window title="my window" border="normal" hflex="min">
					my window is here
					</window>
				</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-window-embedded")).$n("cave")).height(),
	)();
	await t.expect(verifyVariable_cafe_0_0 < 24).ok();
});
