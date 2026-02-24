import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1654TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1654TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
		1. Click on color input and try to enter character \'A\' or \'a\', should see \'A\' or \'a\' showed.
		2. Change to colorpicker and try again.
	</label>
	<colorbox width="30px" height="25px" />
</zk>`,
	);
	await t.click(Selector(() => jq(".z-colorbox")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq(zk.Widget.$(jq(".z-colorpalette")).$n("hex-inp")))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => jq(zk.Widget.$(jq(".z-colorpalette")).$n("hex-inp"))[0]),
		ztl.normalizeText("A"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("A"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-colorpalette")).$n("hex-inp")).val(),
				)(),
			),
			"should see 'A' or 'a' showed",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-colorbox")).$n("picker-btn")),
	);
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(zk.Widget.$(jq(".z-colorpicker")).$n("hex-inp")))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(zk.Widget.$(jq(".z-colorpicker")).$n("hex-inp"))[0],
			),
		);
	await ztl.waitResponse(t);
	await t.pressKey(
		"end backspace backspace backspace backspace backspace backspace backspace A",
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("A"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-colorpicker")).$n("hex-inp")).val(),
				)(),
			),
			"should see 'A' or 'a' showed",
		);
});
