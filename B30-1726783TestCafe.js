import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1726783TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1726783TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window onCreate="add(self)">
			The Selected tab must be true.       
				Tab 1: <label id="info1"/>
				Tab 2: <label id="info2"/>
			<zscript>
			void dump() {
				info1.value = "" + tab1.isSelected();
				info2.value = "" + tab2.isSelected();
			}
			void add(Component comp){
				Tabbox tabbox = new Tabbox();
				tabbox.addEventListener(Events.ON_SELECT, new EventListener(){
					public void onEvent(Event event) {
						dump();
					}
				});
				tabbox.setParent(comp);
				Tabs tabs = new Tabs();
				Tab tab = new Tab("tab1");
				tab.setId("tab1");
				tab.setParent(tabs);
				tab =new Tab("tab2");
				tab.setId("tab2");
				tab.setParent(tabs);
				tabs.setParent(tabbox);
			
				dump();
			}
			</zscript>
		</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("info1", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("info2", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t.click(Selector(() => zk.Desktop._dt.$f("tab2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("info1", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("info2", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t.click(Selector(() => zk.Desktop._dt.$f("tab1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("info1", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("info2", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("false"));
});
