import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1936366TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1936366TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Click the "Warning" button, and then close it, and then you should see the focus on the input element.</n:p>
				<separator/>
				<window title="Messagebox demo" border="normal">
					<textbox id="focus"/>
					<button label="Warning" width="100px">
						<attribute name="onClick"><![CDATA[{
							Messagebox.show("Warning is pressed", "Warning", Messagebox.OK,
								Messagebox.EXCLAMATION, new EventListener() {
									public void onEvent(Event event) throws Exception {
										focus.focus();
									}
								});

						}]]></attribute>
					</button>
				</window>
			</zk>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window").find(".z-textbox:focus")[0],
			)(),
		)
		.ok();
});
