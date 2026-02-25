import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1579515TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1579515TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="win" context="menu" border="normal" contentStyle="background-color:blue">
				<menupopup id="menu">
					<menu label="Save"/>
				</menupopup> 
			</window>`,
	);
	await t.rightClick(Selector(() => zk.Desktop._dt.$f("win", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("menu", true)).is(":visible"),
			)(),
		)
		.ok();
});
