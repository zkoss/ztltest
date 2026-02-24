import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2997079TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2997079TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="main" xmlns:w="http://www.zkoss.org/2005/zk/client">
	<label id="i" value="Click test1 and then test2. Then, you shall see the background becomes blue"/>
	<button label="test1">
		<attribute name="onClick"><![CDATA[
	Script s = new Script();
	s.setContent("function chkgnd(n) {n.setStyle(\'background:blue\');}");
	s.setParent(main);
		]]></attribute>
	</button>
	<button label="test2" w:onClick="chkgnd(this.$f().i)"/>
</window>`,
	);
	await t.click(Selector(() => jq('@button[label="test1"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="test2"]')[0]));
	await ztl.waitResponse(t);
	let css_cafe = await ClientFunction(() =>
		jq(".z-label").css("background-color"),
	)();
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("blue"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(".z-label").css("background-color"),
					)(),
				),
			),
		)
		.ok(
			ztl.normalizeText(
				"css: [await ClientFunction(() => jq('.z-label').css('background-color'))()]",
			),
		);
});
