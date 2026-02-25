import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1868454TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1868454TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>If a modal window is nested within another modal window, the inner one
			is "NOT" shown only inside the borders of the outer one.
			It means you should able to see window 2.</n:p>
				<button id="goBtn" label="go" onClick="win1.doModal()" />
				<window title="window 1" width="400px" height="400px" id="win1"
					visible="false">
					<button id="win2Btn" label="open window 2" onClick="win2.doModal()" />		
					<button id="detachBtn1" label="close window 1" onClick="win1.detach()" />
					<window title="window 2" id="win2" visible="false" width="400px">
						<label value="window 2" />	
						<button id="detachBtn2" label="close window 2" onClick="win2.detach()" />
					</window>
				</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("goBtn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("win2Btn", true).$n()));
	await ztl.waitResponse(t);
	let win1ZIndex_cafe = await ClientFunction(() =>
		jq("$win1").css("z-index"),
	)();
	let win2ZIndex_cafe = await ClientFunction(() =>
		jq("$win2").css("z-index"),
	)();
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() => jq("$win2").css("z-index"))(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() => jq("$win1").css("z-index"))(),
	);
	await t.expect(parseInt(win2ZIndex_cafe) > parseInt(win1ZIndex_cafe)).ok();
});
