import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3201879TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3201879TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<popup id="pop">
		<button label="Click me if you cannot see a dialog, that is a bug!" onClick="alert(&quot;yes! The bug is fixed!&quot;)"/>
	</popup>
	<window border="none" height="100%">
		<window id="win" visible="false" position="center">
			<button label="click again" onClick="pop.open(self)"/>
		</window>
		<button label="Click Me first." onClick="win.doModal()"/>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="Click Me first."]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="click again"]')[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(
					'@button[label="Click me if you cannot see a dialog, that is a bug!"]',
				)[0],
		),
	);
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
		.eql(ztl.normalizeText("yes! The bug is fixed!"));
});
