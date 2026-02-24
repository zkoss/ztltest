import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2020TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2020TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div>
		input \'123\' into textbox and press \'enter\' then should be able
		to edit textbox value
	</div>
	<window apply="org.zkoss.zktest.test2.B70_ZK_2020_Composer">
		<grid id="myGrid" hflex="">
			<columns id="record">
				<column>
					<textbox id="myFilter" />
				</column>
			</columns>
		</grid>
	</window>
</zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3");
	await ztl.waitResponse(t);
	await t.expect("false").ok("should be able to edit textbox value");
});
