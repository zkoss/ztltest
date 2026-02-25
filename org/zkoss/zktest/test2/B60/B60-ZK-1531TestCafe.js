import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1531TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1531TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
      <zk>
        <window id="win1" title="new page title" border="normal">
          Right click on the button, should only see "Right clicked" message showed.<separator/>
          <button image="/img/inet.png" onClick=\'lbl.value="Left Clicked"\' onRightClick=\'lbl.value="Right Clicked"\'></button>
          <label id="lbl" style="color: red"/>
        </window>
      </zk>`,
	);
	await t.rightClick(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(Right Clicked)")[0],
			)(),
		)
		.ok("should only see 'Right clicked' message showed.");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(Left Clicked)")[0],
			)(),
		)
		.notOk("should only see 'Right clicked' message showed.");
});
