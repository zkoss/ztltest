import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1808TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1808TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native">
select tab2 and close it, should not cause an error, also creation of new tabs should not be affected

	<tabbox id="tabbox" >
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1" closable="true"/>
			<tab id="tab2" label="Tab 2" closable="true"/>
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel id="panel1">
				Panel 1
			</tabpanel>
			<tabpanel id="panel2">
				Panel 2
			</tabpanel>
		</tabpanels>
	</tabbox>
	<button label="add" >
		<attribute name="onClick">
			<![CDATA[
			         Tab tab = new Tab("Tab new");
			         tab.setClosable(true);
			         tabs.appendChild(tab);
			         Tabpanel tabpanel = new Tabpanel();
			         tabpanel.appendChild(new Label("Content new"));
			         tabpanels.appendChild(tabpanel);			 
			]]>
		</attribute>
	</button>
	<idspace id="sec">
	same should work in accordion mold
	
		<tabbox id="tabbox-accordion" mold="accordion" width="200px">
			<tabs id="tabs">
				<tab id="tab1" label="Tab 1" closable="true"/>
				<tab id="tab2" label="Tab 2" closable="true"/>
			</tabs>
			<tabpanels id="tabpanels">
				<tabpanel id="panel1">
					Panel 1
				</tabpanel>
				<tabpanel id="panel2">
					Panel 2
				</tabpanel>
			</tabpanels>
		</tabbox>
		<button label="add" >
			<attribute name="onClick">
				<![CDATA[
				         Tab tab = new Tab("Tab new");
				         tab.setClosable(true);
				         tabs.appendChild(tab);
				         Tabpanel tabpanel = new Tabpanel();
				         tabpanel.appendChild(new Label("Content new"));
				         tabpanels.appendChild(tabpanel);			 
				]]>
			</attribute>
		</button>
			
	</idspace>
</zk>`,
	);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-tabbox .z-tab-text:contains(Tab 2)")).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-tabbox .z-tab-text:contains(Tab 2)")).$n("cls"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
	await t.click(Selector(() => jq(".z-button:contains(add)").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(".z-tabbox-accordion .z-tab-text:contains(Tab 2)"),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(".z-tabbox-accordion .z-tab-text:contains(Tab 2)"),
			).$n("cls"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
	await t.click(Selector(() => jq(".z-button:contains(add)").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
