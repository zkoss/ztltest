import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2379135TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2379135TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
			<html><![CDATA[  
			<ol>
			<li>Right click the second item, and then it shall be selected</li>
			<li>Right click the third item, and then it shall be selected</li>
			<li>Right click the button, and the fourth item shalln\'t be selected.</li>
			</ol>
			]]></html>
			<zscript><![CDATA[
			void show() {
				i.value = "selcted: " + l.selectedItem.label;
			}
			]]></zscript>
			<listbox id="l">
				<listitem id="li1" label="First"/>
				<listitem id="li2" label="Second (right-click)" onRightClick="show()"/>
				<listitem id="li3" label="Third (context)" context="editPopup"/>
				<listitem>
					<listcell><button id="btn1" label="context but no select" context="editPopup"/></listcell>
				</listitem>
			</listbox>
			<label id="i" multiline="true"/>
			<menupopup id="editPopup" onOpen="show()">
			    <menuitem label="Undo"/>
			    <menuitem label="Redo"/>
			    <menu label="Sort">
					<menupopup>
				        <menuitem label="Sort by Name" autocheck="true"/>
				        <menuitem label="Sort by Date" autocheck="true"/>
					</menupopup>
			    </menu>
			</menupopup>
			</window>`,
	);
	await t.rightClick(Selector(() => zk.Desktop._dt.$f("li2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("l", true).$n().innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Second"), "");
	await t.rightClick(Selector(() => zk.Desktop._dt.$f("li3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("l", true).$n().innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Third"), "");
	await t.rightClick(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("l", true).$n().innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Third"), "");
});
