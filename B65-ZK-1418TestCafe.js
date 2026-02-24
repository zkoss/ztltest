import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1418TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1418TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <zscript><![CDATA[
		import org.zkoss.zul.ListModelList;
		String[] userNamesA = { "Tony", "Ryan", "SELECT ME", "Wing", "Sam" };
		ListModelList modelA = new ListModelList(userNamesA);
		String[] userNamesB = { "Peter", "Paul" };
		ListModelList modelB = new ListModelList(userNamesB);
		void b1Click() {
			sel1.setModel(modelB);
			modelB.addToSelection(modelB.getElementAt(1));
		}
	]]></zscript>
                    <label multiline="true">
                      1. Select "SELECT ME" in the selectbox.
	2. Click "Change Model" button, if you see a error messagebox, it is a bug.
                    </label>
                    <selectbox id="sel1" model="\${modelA}">
                      <template name="modelA">Name is \${ each }</template>
                    </selectbox>
                    <button label="Change Model" onClick="b1Click()"/>
                  </zk>`,
	);
	await t
		.click(Selector(() => jq(jq("select"))[0]))
		.click(
			Selector(
				() => jq(jq("select")).find("option:contains(SELECT ME)")[0],
			),
		)
		.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("error messagebox should not show");
});
