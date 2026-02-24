import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2904793TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2904793TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
<label value="1. It is correct when you see \'onChange has been triggered!\' \nafter input any words into following textbox." />
<label value="2. It is correct when you see \'onOK has been triggered!\' after press Enter key." />
<textbox id="myTextbox" onOK="okEvtLabel.setVisible(true);" onChanging="changeEvtLabel.setVisible(true);"/>
<label id="changeEvtLabel" value="onChange has been triggered!" visible="false" />
<label id="okEvtLabel" value="onOk has been triggered!" visible="false" />
</vbox>`,
	);
	await t.typeText(
		Selector(() => jq(zk.Desktop._dt.$f("myTextbox", true))[0]),
		ztl.normalizeText("k"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("changeEvtLabel", true)).is(":visible"),
			)(),
		)
		.ok("onChange event was not triggered!");
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("myTextbox", true)).focus();
	})();
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("okEvtLabel", true)).is(":visible"),
			)(),
		)
		.ok("onOk event was not triggered!");
});
