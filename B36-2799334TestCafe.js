import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2799334TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2799334TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="IE only" border="normal" width="500px">
        <toolbarbutton label="step 1-click here to show pop" popup="popme"/>
        <popup id="popme" width="330px">
          hello
          <textbox id="tb1" value="step 2-click here to focus this popup." width="300px"/>
        </popup>
        <textbox id="tb2" value="step 3-click here, it should select all the words." onFocus="self.select();" width="400px"/>
      </window>`,
	);
	await t.click(Selector(() => jq(".z-toolbarbutton-content")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$tb1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$tb1").css("box-shadow"))(),
			),
		)
		.notEql(ztl.normalizeText(""), "The second textbox should have focus");
	await ClientFunction(() => {
		jq("$tb2").focus();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("$tb2")).getSelectionRange()[1],
				)(),
			),
		)
		.eql(ztl.normalizeText("50"), "The text should be selected");
});
