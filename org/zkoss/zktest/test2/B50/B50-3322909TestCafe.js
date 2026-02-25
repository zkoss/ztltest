import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3322909TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3322909TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<n:pre xmlns:n="xhtml">
			
					1.click set setModel , remove items 
					2.click set setModel , remove items 
					3. in the second time , you will found the emptyMessage is not showing up.
					
					It only happened when you have a height on listbox
				</n:pre>
				<window>
			
					<listbox id="test" height="350px"
						emptyMessage="No items match your search">
						<listhead sizable="true">
							<listheader label="Type" width="520px"></listheader>
							<listheader label="Content" hflex="min"></listheader>
							<listheader label="Content" hflex="1"></listheader>
						</listhead>
					</listbox>
					<zscript><![CDATA[
				ArrayList list = new ArrayList();
				list.add("test");
				list.add("test3");
				list.add("test3");
				list.add("test3");
				list.add("test3");
				test.setModel(new ListModelList(list));
			]]></zscript>
					<hlayout>
						<button id="btn1" label="test set model (Add items)">
							<attribute name="onClick"><![CDATA[
				ArrayList list = new ArrayList();
				list.add("test");
				list.add("test3");
				test.setModel(new ListModelList(list));
			]]></attribute>
						</button>
						<button id="btn2" label="test remove items">
							<attribute name="onClick"><![CDATA[
				test.setModel(new ListModelList());
			]]></attribute>
						</button>
					</hlayout>
				</window>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("test", true).$n("empty"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("No items match your search"), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("test", true).$n("empty"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("No items match your search"), "");
});
