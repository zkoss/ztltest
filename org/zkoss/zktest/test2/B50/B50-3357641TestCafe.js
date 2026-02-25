import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3357641TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3357641TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
			Please scroll to the middle of the list, and click the buttom "Run Bug (make a..."
			<separator/>
			You should see there lists "Second items0" ~ "Second items4" only
			<zscript><![CDATA[
			import java.util.ArrayList;
			import java.util.List;
			
			import org.zkoss.zk.ui.Component;
			import org.zkoss.zk.ui.util.GenericForwardComposer;
			import org.zkoss.zul.ListModelList;
			import org.zkoss.zul.Listbox;
			import org.zkoss.zul.Listcell;
			import org.zkoss.zul.Listitem;
			import org.zkoss.zul.ListitemRenderer;
			
			public class ListboxControl extends GenericForwardComposer {
			
			Listbox testListbox;
			public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
			
			testListbox.setItemRenderer(new ListitemRenderer() {
			
			
			public void render(Listitem arg0, Object arg1, int index) throws Exception {
			arg0.setValue(arg1);
			
			DummyItem di = (DummyItem) arg1;
			
			Listcell lc = new Listcell();
			
			lc.setLabel(di.getTest());
			
			lc.setParent(arg0);
			}
			});
			
			List ditems = generateDummyItems("First items", 500);
			
			ListModelList lstModelList = new ListModelList(ditems);
			
			testListbox.setModel(lstModelList);
			
			}
			
			public void onClick$btnNewModel() {
			List ditems = generateDummyItems("Second items", 5);
			
			ListModelList lstModelList = new ListModelList(ditems);
			
			testListbox.setModel(lstModelList);
			}
			
			public static List generateDummyItems(String prefix, int size) {
			
			List newList = new ArrayList();
			
			for (int i = 0; i < size; i++) {
			newList.add(new DummyItem(prefix + i));
			}
			return newList;
			}
			
			public static class DummyItem {
			protected String test;
			
			public DummyItem() {
			
			}
			
			public DummyItem(String test) {
			setTest(test);
			}
			
			public String getTest() {
			return test;
			}
			
			public void setTest(String test) {
			this.test = test;
			}
			
			}
			
			}               
			]]></zscript>
			<window id="win" border="none" apply="ListboxControl">
			<custom-attributes org.zkoss.zul.listbox.rod="true"/>
			<listbox checkmark="true" multiple="true" id="testListbox" height="400px" width="800px">
			<listhead sizable="true">
			<listheader label="Test"/>
			</listhead>
			</listbox>
			
			<button id="btnNewModel" label="Run Bug (make a scroll to the middle first)"/>
			</window>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("testListbox", true).$n()),
		scrollType: "vertical",
		percent: "0.5",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnNewModel", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("testListbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("items0"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("testListbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(1)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("items1"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("testListbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("items2"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("testListbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(3)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("items3"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("testListbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(4)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("items4"), "");
	await t
		.expect(
			await ClientFunction(
				() =>
					jq(zk.Desktop._dt.$f("testListbox", true).$n("rows")).find(
						".z-listcell",
					)[5] != null,
			)(),
		)
		.notOk();
});
