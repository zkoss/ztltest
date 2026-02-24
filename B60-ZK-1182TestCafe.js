import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1182TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1182TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    Please type some words in the textbox and blur it, you should see a dialog with "org.zkoss.zk.ui.event.StubEvent:onStub"
                    <textbox stubonly="true" onChange=\'alert(event.getClass().getName()+":"+event.getName())\'/>
                  </zk>`,
	);
	await ClientFunction(() => {
		jq(".z-textbox").focus();
	})();
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("org.zkoss.zk.ui.event.StubEvent:onStub"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"should see a dialog with 'org.zkoss.zk.ui.event.StubEvent:onStub'",
		);
});
