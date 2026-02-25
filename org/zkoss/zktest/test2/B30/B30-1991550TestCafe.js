import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1991550TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1991550TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<groupbox id="gb" mold="3d" width="300px">
        <caption image="/test2/img/inet.png" label="fruits">
          <toolbarbutton label="action" image="/test2/img/inet.png">
          </toolbarbutton>
        </caption>
        When you click the right image, this groupbox cannot be collapsed, but the left image can.
      </groupbox>`,
	);
	await t.click(Selector(() => jq(".z-caption-image")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-label").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq(".z-caption-image")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-toolbarbutton")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-label").is(":visible"))())
		.ok();
});
