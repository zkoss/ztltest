import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2959024TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2959024TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<zscript>
import org.zkoss.zk.ui.util.*;
</zscript>
<div height="100px" width="300px" id="div">
  <attribute name="onLater">
  Thread.sleep(3000);
  Clients.clearBusy();
alert(event.data);
  </attribute>
</div>
<button label="Click Me">
	<attribute name="onClick">
		Clients.showBusy("You should see an alert about the result after 2 seconds.");
		Events.echoEvent("onLater", div, "If you can see the message, the bug is fixed!");
	</attribute>
</button>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0])).wait(5000);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).ok();
});
