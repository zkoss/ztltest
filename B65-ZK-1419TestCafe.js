import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1419TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1419TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. Change browser language to English.
	2. Type anything in the textbox to show errorbox.
	3. Mouseover on the errorbox to show the tooltip text and should be "Click to re-enter data".
	</label>
	<textbox id="emailTextbox" width="175px" constraint="/[a-zA-Z0-9_\\-.+]+@[a-zA-Z0-9_\\-.+]+/: invalid e-mail" maxlength="255" />
</zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq("@textbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("@textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3 1 2 3 1 2 3");
	await t.pressKey("tab");
	await t.hover(Selector(() => jq(".z-errorbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Click to re-enter data"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-errorbox-content").attr("title"),
				)(),
			),
			"the tooltip text should be 'Click to re-enter data'.",
		);
});
