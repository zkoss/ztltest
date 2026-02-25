import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1136TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1136TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<vlayout>
		<label>1. Click "show notification" button</label>
		<label>2. Click "close me" button</label>
		<label>3. You should see two notification messages showed.</label>
	</vlayout>
	<window id="win_main" title="Hello Notification!!" border="normal" width="100%">
		<button label="show notification" autodisable="self">
			<attribute name="onClick"><![CDATA[
				Window win = (Window) Executions.getCurrent().createComponents("/test2/B60-ZK-1136-1.zul", null, null);
				win.addEventListener(Events.ON_CLOSE, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event event) throws Exception {
						Clients.showNotification("ok 1", Clients.NOTIFICATION_TYPE_INFO, win_main, "top_right", -1);
						Clients.showNotification("ok 2");
					}
				});
				win.doModal();
			]]></attribute>
		</button>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(show)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(Close)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-notification").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 2)
		.ok("You should see two notification messages showed.");
});
