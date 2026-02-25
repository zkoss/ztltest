import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1873021TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1873021TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
			If you did not see any Exception like below, then it is OK.<br/>
			<br/>
			java.lang.IndexOutOfBoundsException: Index: 16, Size: 4<br/>
				at org.zkoss.zk.ui.AbstractComponent$ChildIter.<init>(AbstractComponent.java:1606)<br/>
				at org.zkoss.zk.ui.AbstractComponent$ChildIter.<init>(AbstractComponent.java:1599)<br/>
				at org.zkoss.zk.ui.AbstractComponent$1.listIterator(AbstractComponent.java:234)<br/>
				at java.util.AbstractSequentialList.get(AbstractSequentialList.java:71)<br/>
				at org.zkoss.zul.Listbox$1.get(Listbox.java:168)<br/>
				at org.zkoss.zul.Listbox.getItemAtIndex(Listbox.java:490)<br/>
				at org.zkoss.zul.Listbox.onInitRender(Listbox.java:1331)<br/>
				at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)<br/>
				at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)<br/>
			]]></html>
			<window title="Live Data Demo" border="normal">
				<zscript>
					String[] data = new String[3];
					for(int j=0; j &lt; data.length; ++j) {
						data[j] = "option "+j;
					}
					ListModel strset = new SimpleListModel(data);
				</zscript>
				<listbox id="list" width="200px" rows="10" model="&#36;{strset}">
					<listhead>
						<listheader label="Load on Demand" sort="auto"/>
					</listhead>
				</listbox>
			</window>
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(zk.Desktop._dt.$f("list", true))[0],
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("list", true)).find(".z-listcell")
							.length,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
});
