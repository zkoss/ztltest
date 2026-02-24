import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2988261TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2988261TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
		<portallayout width="100%" height="100%" maximizedMode="whole">
		<portalchildren width="50%" height="100%">
		<panel id="panel" border="normal" title="test" height="400px" maximizable="true">
		<toolbar>
		<combobox id="cb"/>
		</toolbar>
		<panelchildren>
		<window width="100%" height="100%" />
		</panelchildren>
		</panel>
		</portalchildren>
		</portallayout>
		</zk>`,
	);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("panel", true).$n("max")))
		.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")));
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() =>
			jq(zk.Desktop._dt.$f("panel", true)).css("zIndex"),
		)(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() =>
			jq(zk.Desktop._dt.$f("cb", true).$n("pp")).css("zIndex"),
		)(),
	);
	await t.expect(verifyVariable_cafe_1_1 > verifyVariable_cafe_0_0).ok();
});
