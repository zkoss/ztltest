import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1370TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1370TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    Click "Test" button, should not see error message box.<separator/>
                    <datebox id="dbx"/>
                    <button label="Test" onClick=\'dbx.setDisplayedTimeZones("GMT+12");\'>
                      <attribute name="onClick"><![CDATA[
			dbx.setDisplayedTimeZones("GMT+12");
			dbx.setDisplayedTimeZones(Collections.emptyList());
		]]></attribute>
                    </button>
                  </zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-popup-cl").is(":visible"))())
		.notOk("should not see error message box.");
});
