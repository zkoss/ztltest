import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1819264TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1819264TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<borderlayout height="300px">
	<center autoscroll="true">
		<div height="500px">
			Please focus in the textbox, then focus out, and then when
			you scroll up/down the scroll bar, the error box should be
			moved according to the textbox.
			<separator />
			<textbox id="tb" value="show Error" constraint="/.+@.+\\.[a-z]+/" />
		</div>
	</center>
</borderlayout>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tb", true).focus();
	})();
	await t.pressKey("tab");
	await t.wait(300);
	await t.expect(await ClientFunction(() => !!jq("@errorbox")[0])()).ok();
	let str_cafe = await ClientFunction(() => jq("@errorbox")[0].style.top)();
	let beforeTop_cafe = parseInt(str_cafe);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq(".z-center")).$n()),
		scrollType: "vertical",
		percent: "5.0",
	});
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq(zk.Desktop._dt.$f("tb", true)).offset().top,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq("@errorbox").offset().top)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq(".z-center")).$n()),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	str_cafe = await ClientFunction(() => jq("@errorbox")[0].style.top)();
	let afterTop_cafe = parseInt(str_cafe);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(beforeTop_cafe),
		ztl.normalizeText(afterTop_cafe),
		ztl.normalizeText("1"),
	);
});
