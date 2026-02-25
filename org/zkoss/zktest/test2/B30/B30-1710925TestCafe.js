import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1710925TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1710925TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="w" title="Test of the style component">
				Bug 1710925: you shall see the background color changed when
				pressing the buttons in order.
			        <separator/>
			        The 3rd botton work slow in IE6, IE7 and doesn\'t work in SA, it won\'t fixed.
			        <separator/>
				<button id="btn1" label="1. change background to yellow">
					<attribute name="onClick">{
				Style s = new Style();
				s.setContent("body {background: yellow}");
				s.setId("style");
				s.setParent(w);
					}</attribute>
				</button>
				<button id="btn2" label="2. change background to blue">
					<attribute name="onClick">
					style.setContent("body {background: blue}");
					</attribute>
				</button>
				<button id="btn3" label="3. remove the background">
					<attribute name="onClick">
				style.detach();
					</attribute>
				</button>
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let color_cafe = await ClientFunction(() =>
		jq("body").css("backgroundColor"),
	)();
	await t
		.expect(ztl.normalizeText("rgb(255, 255, 0)#ffff00yellow"))
		.contains(ztl.normalizeText(color_cafe), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	color_cafe = await ClientFunction(() =>
		jq("body").css("backgroundColor"),
	)();
	await t
		.expect(ztl.normalizeText("rgb(0, 0, 255)#0000ffblue"))
		.contains(ztl.normalizeText(color_cafe), "");
});
