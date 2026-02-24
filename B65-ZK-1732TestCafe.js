import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1732TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1732TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Click <button label="show/hide">
		<attribute name="onClick"><![CDATA[
			lb.setVisible(!lb.isVisible());
			lb.invalidate();
		]]></attribute>
	</button> button, should see a listbox show/hide accordingly.
	<hlayout>
		<listbox id="lb" visible="false">
			<listhead>
				<listheader label="column" />
			</listhead>
			<listitem forEach="1,2,3" label="item \${each}" />
		</listbox>
	</hlayout>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-listbox")[0])())
		.ok("should see a listbox show");
	await t.click(Selector(() => jq(".z-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-listbox").is(":visible"))())
		.notOk("should see a listbox hide");
});
