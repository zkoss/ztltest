import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1873950TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1873950TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			It is wrong, when modals are nested, the inner one is positioned to the left of the screen center.(IE only)
				<button id="win1Btn" label="go" onClick="win1.doModal()" />
				<window id="win1" width="300px" height="200px" visible="false"
					title="1" style="overflow:visible" closable="true">
					<button id="win2Btn" label="go" onClick="win2.doModal()" />
					<window id="win2" width="300px" height="200px" visible="false"
						title="2" closable="true">
						<button label="go" disabled="true" />
					</window>
				</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("win1Btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("win2Btn", true).$n()));
	await ztl.waitResponse(t);
	let win1ZIndex_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win1", true)).css("z-index"),
	)();
	let win2ZIndex_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).css("z-index"),
	)();
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() =>
			jq(zk.Desktop._dt.$f("win2", true)).css("z-index"),
		)(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() =>
			jq(zk.Desktop._dt.$f("win1", true)).css("z-index"),
		)(),
	);
	await t.expect(parseInt(win2ZIndex_cafe) > parseInt(win1ZIndex_cafe)).ok();
});
