import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-822TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-822TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <zscript>
                      EventQueue que = EventQueues.lookup("iframe", "group", true);
	void publish(){
                        String text = tbx.getValue();
                        que.publish(new Event("onGroupTest", null, text));
                      }
                    </zscript>
                    <vlayout>
                      <div>
                        Please type some words into the textbox and press ENTER.
			Then, if there is no exception, it is correct.
                        <textbox id="tbx" onChange="publish()" onOK="publish()"/>
                      </div>
                      <iframe width="400px" height="600px" src="test2/B50-ZK-822-iframe.zul"/>
                    </vlayout>
                  </zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox:eq(0)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3 enter");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
});
