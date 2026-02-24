import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1690583TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1690583TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
				<hbox>
					<popup width="300px" id="help">
					Help is coming.
					</popup>
					<textbox id="t" visible="false"/>
					<label tooltip="help" value="Help" />
				</hbox>
				align
				<button label="toggle" id="btn" onClick="t.visible = !t.visible"/>
			</vbox>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true)).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true)).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true)).is(":visible"),
			)(),
		)
		.notOk();
});
