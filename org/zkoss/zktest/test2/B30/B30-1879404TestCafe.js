import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1879404TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1879404TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<window id="win" title="Debug" width="500px" border="normal">
	<vbox id="input" visible="false">
		<hbox>
			<textbox id="msg" style="width:240px" onOK="ms.value = self.value" />
			<label id="ms" value="Please type words in the textbox and press Enter button, and then you should see this message will be changed like your input.(IE only)"/>
		</hbox>
	</vbox>
	<div id="login">
  		<vbox>
    	<label value="Enter Chat" style="font-weight: bold"/>
   		<hbox>
      		NickName:
      		<textbox id="nickname" constraint="no empty">
      			<attribute name="onOK">
			  		nickname.setRawValue("");
			  		login.setVisible(false);
					input.setVisible(true);
      			</attribute>
      		</textbox>
      		Please type words and press Enter button.
    	</hbox>
  		</vbox>
	</div>
</window>
</zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("nickname", true))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("nickname", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3");
	await ClientFunction(() => {
		zk.Desktop._dt.$f("nickname", true).focus();
	})();
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$msg").is(":visible"))())
		.ok();
	if (
		await ClientFunction(
			() => jq(jq("$msg"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("$msg")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("r y a n space i s space b o r i n g");
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("$msg").focus();
	})();
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("ms", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("ryan is boring"));
});
