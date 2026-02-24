import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-504TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-504TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
			<ul><li>You shall see "onCreated received" inside the following window.</li></ul>
			]]></html>
			
			<zscript><![CDATA[
			public class Tooltip extends org.zkoss.zk.ui.util.GenericForwardComposer {
				Label tip;
				public void onCreate$tip(Event event) {
					tip.setValue("onCreated received");
				}
			}
			]]></zscript>
			
			<window border="normal" apply="Tooltip">
				<label id="tip"/>
			</window>
			
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(onCreated received)")[0],
			)(),
		)
		.ok("event fired");
});
