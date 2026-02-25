import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1377TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1377TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. in Chrome, edit textbox1 and tab, it should focus on textbox2 and select all of textbox2 and the window title should change to the value you edited.
	2. in IE, edit textbox1 and tab, it should focus on textbox2 and select all of textbox2 and the window title should change to the value you edited.
	</label>
	<window id="win" title="no title" border="normal">
		<vlayout>
			<label id="lb" value="no value"/>
			<textbox id="tb1" onChange=\'win.title = self.value\' value="Title 1" />
			<textbox id="tb2" onChange=\'lb.value = self.value\' value="Label 1" />
			<textbox id="tb3" onChange=\'win.title = self.value\' value="Title 3" />
		</vlayout>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-textbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-textbox:eq(0)")[0].value = "";
	})();
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox:eq(0)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-window-embedded")).$n("cap"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("123"),
			"the window title should change to the value you edited",
		);
});
