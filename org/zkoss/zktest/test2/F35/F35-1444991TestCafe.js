import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F35-1444991TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F35-1444991TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<button label="restore window" visible="false" onClick="win.minimized = !win.minimized; self.visible = win.minimized;"/>
			<window id="win" border="normal" title="Maximize and Minimize Demo" height="400px" width="350px" sizable="true" maximizable="true"
			minimizable="true" closable="true" mode="overlapped">
			 <attribute name="onMaximize">
			 if (self.maximized)
			 	alert("The window is maximized!");
			 </attribute>
			 <attribute name="onMinimize">
			 if (self.minimized) {
			 	alert("The window is minimized!");
			 	btn.visible = self.minimized;
			 }
			 </attribute>
			 Please test both maximize and minimize buttons, and then they work well.
			</window>
		</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("win", true).$n("max")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@window[title="ZK Test"] @label')
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("The window is maximized!"));
	await t.click(Selector(() => jq("@window @button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("win", true)).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("body").outerWidth())(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("win", true)).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("body").outerHeight())(),
			),
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("win", true).$n("min")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@window[title="ZK Test"] @label')
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("The window is minimized!"));
	await t.click(Selector(() => jq("@window @button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("win", true)).is(":visible"),
			)(),
		)
		.notOk();
});
