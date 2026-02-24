import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1124TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1124TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <window border="normal" title="hello">
                      <div>
                        1. Click the button below to open the menu.<separator spacing="0px"/>
                        2. Click away from the menu to close it, you should see a message box showed.
                      </div>
                      <button id="btn" label="Click me to popup dynamic menu">
                        <attribute name="onClick"><![CDATA[
				Menupopup contextMenu = new Menupopup();
				contextMenu.addEventListener("onOpen", new EventListener() {
					public void onEvent(Event evt) {
						OpenEvent e = (OpenEvent) evt;
						if (!e.isOpen()) {
							Messagebox.show("Menu Closed...");
							evt.getTarget().detach();
						}
					}
				});
				Menu reportMenu = new Menu("MyMenu");
				contextMenu.appendChild(reportMenu);
				contextMenu.setPage(event.getTarget().getPage());
				contextMenu.open(20,20);
			]]></attribute>
                      </button>
                    </window>
                  </zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(Click)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-window-embedded")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Menu Closed..."))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"should see a message box showed.",
		);
});
