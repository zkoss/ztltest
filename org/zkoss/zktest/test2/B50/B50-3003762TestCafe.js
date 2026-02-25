import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3003762TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3003762TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox width="100%" align="stretch"> 
ZK Online Survey 
<textbox value="Jerry" id="tb" width="150px" onBlur="text.value = self.value; Thread.sleep(200);"/> 
<radiogroup id="radio1" onCheck="choice.value = self.selectedItem.label"> 
<grid> 
<rows> 
<row>
 <cell colspan="5">
Which one area would you like ZK to improve upon?
</cell></row>
<row> 
<radio id="r1" label="IDE Support" /> 
<radio label="Bug Fixing" /> 
<radio label="Performance" /> 
<radio label="Backward Compatibility" /> 
<radio label="Offline Functionality" /> 
</row> 
</rows> 
</grid> 
</radiogroup> 
<hbox> 
You have selected : 
<label id="text" /> 
<label id="choice" /> 
</hbox> 
</vbox>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tb", true).focus();
	})();
	await t.pressKey("tab");
	await t.click(Selector(() => zk.Desktop._dt.$f("r1", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$text").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Jerry"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$choice").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("IDE Support"));
});
