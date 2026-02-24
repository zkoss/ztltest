import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1500TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1500TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <zscript><![CDATA[
	void onMaximize(Component comp) {
		if (comp.isMaximized()) {
			comp.setClosable(false);
		} else {
			comp.setClosable(true);
		}
	}
	]]></zscript>
                    <label multiline="true">
                      1. Click panel\'s maximize icon to maximize.
	2. Click panel\'s restore icon, the size should the same before maximized.
	Also test on Window.
                    </label>
                    <panel title="panel" border="normal" width="300px" height="200px" minimizable="true" collapsible="true" closable="true" maximizable="true" onMaximize="onMaximize(self)">
                      <panelchildren></panelchildren>
                    </panel>
                    <window title="window" border="normal" width="300px" height="200px" minimizable="true" closable="true" maximizable="true" onMaximize="onMaximize(self)" maximized="true">
                    </window>
                  </zk>`,
	);
	let panelWidth_cafe = await ClientFunction(() => jq("@panel").width())();
	let panelHeight_cafe = await ClientFunction(() => jq("@panel").height())();
	await t.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(panelWidth_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@panel").width())(),
			),
			"the width should the same before maximized",
		);
	await t
		.expect(ztl.normalizeText(panelHeight_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@panel").height())(),
			),
			"the height should the same before maximized",
		);
	let windowWidth_cafe = await ClientFunction(() => jq("@window").width())();
	let windowHeight_cafe = await ClientFunction(() =>
		jq("@window").height(),
	)();
	await t.click(Selector(() => zk.Widget.$(jq("@window")).$n("max")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@window")).$n("max")));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(windowWidth_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@window").width())(),
			),
			"the width should the same before maximized",
		);
	await t
		.expect(ztl.normalizeText(windowHeight_cafe))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@window").height())(),
			),
			"the height should the same before maximized",
		);
});
