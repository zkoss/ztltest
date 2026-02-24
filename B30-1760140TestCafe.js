import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1760140TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1760140TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>I\'ve tested and discover a bug in the comboitems when the combobox is
		placed inside an overlapped window.
		
		When you drag the overlapped window within your screen with the items of
		the combobox shown, these items remains in the same place instead of moving
		with the window.</n:p>
			<window id="win" mode="overlapped" border="normal" width="350px"
			sizable="true">
			<caption label="Hi there!"/>
			<combobox id="cb">
			<comboitem label="Simple and Rich"/>
			<comboitem label="Cool!"/>
			<comboitem label="Thumbs Up!"/>
			</combobox>
		</window>
		</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")));
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("cb", true).$n("pp")).is(":visible"),
			)(),
		)
		.ok();
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => zk.Widget.$(jq("@window")).$n("cap")),
		150,
		150,
		{ offsetX: 10, offsetY: 10 },
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("cb", true).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
});
