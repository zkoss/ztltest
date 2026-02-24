import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1689TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1689TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<zscript><![CDATA[
		void updateInfo(Window win, Label lLabel, Label tLabel) {
			lLabel.setValue(win.getLeft());
			tLabel.setValue(win.getTop());
		}
	]]></zscript>
	<label multiline="true">
	1. Move the popup window
	2. Minimize/Maximize the popup window.
	3. Click restore button.
	4. If the Left/Top value changed, it is a bug.
	</label>
	<window title="parent win" border="normal">
		<window id="rWin" title="relative win"
			border="normal" mode="popup" position="parent"
			minimizable="true" maximizable="true"
			onCreate="updateInfo(self, lLabel, tLabel);"
			onMove="updateInfo(self, lLabel, tLabel);"
			onMaximize="updateInfo(self, lLabel, tLabel);"
			onMinimize="updateInfo(self, lLabel, tLabel);">
		</window>
		Left: <label id="lLabel" />
		Top: <label id="tLabel" />
    <separator />
		<button label="restore">
			<attribute name="onClick"><![CDATA[
				rWin.setVisible(true);
			]]></attribute>
		</button>
	</window>
</zk>`,
	);
	await t.dragToElement(
		Selector(() =>
			zk.Widget.$(jq("@window.z-window-popup:contains(relative win)")).$n(
				"cap",
			),
		),
		Selector(() =>
			zk.Widget.$(
				jq("@window.z-window-embedded:contains(parent win)"),
			).$n("cap"),
		),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 2,
			destinationOffsetY: 2,
		},
	);
	await ztl.waitResponse(t);
	let left_cafe = await ClientFunction(() =>
		jq(".z-label:contains(px):eq(0)").text().replace(/\s/g, " "),
	)();
	let top_cafe = await ClientFunction(() =>
		jq(".z-label:contains(px):eq(1)").text().replace(/\s/g, " "),
	)();
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(
						jq("@window.z-window-popup:contains(relative win)"),
					).$n("cap"),
				),
			).$n("max"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(
						jq("@window.z-window-popup:contains(relative win)"),
					).$n("cap"),
				),
			).$n("max"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(restore)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(px):eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(left_cafe), "the Left value should not change");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(px):eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(top_cafe), "the Top value should not change");
});
