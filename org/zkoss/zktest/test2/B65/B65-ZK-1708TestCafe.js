import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1708TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1708TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<window hflex="1" vflex="1" border="normal" title="window">
		Click "append" button, should see notification showed.
		<button label="append" onClick="append()">
			<attribute name="onClick"><![CDATA[
				include2.setSrc("/test2/B65-ZK-1708_1.zul?a=b");
			]]></attribute>
		</button>
		<include id="include2" hflex="1" vflex="1" src="" />
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-notification")[0])())
		.ok("should see notification showed.");
});
