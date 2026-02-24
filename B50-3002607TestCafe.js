import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3002607TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3002607TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<bandbox id="bb" readonly="true">
					<bandpopup>
						<textbox id="tb" value="test" />
					</bandpopup>
				</bandbox>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("bb", true).$n("btn")));
	await ztl.waitResponse(t);
	let before_cafe = await ClientFunction(() => jq(".z-textbox").val())();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tb", true).$n().focus();
	})();
	await ztl.waitResponse(t);
	await t.pressKey("end");
	await ztl.waitResponse(t);
	await t.pressKey("backspace");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(before_cafe))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox").val())(),
			),
			"",
		);
});
