import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-761-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-761-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
			Please click the reset button, and then you should not see any exception dialog.
			 <zscript>
			 org.zkoss.zul.ListModelList model = new org.zkoss.zul.ListModelList();
			 model.add("A");
			 model.add("B");
			 model.add("C");
			 model.add("D");
			    </zscript>
			 <grid id="grid" width="300px" model="\${model}">
			  <template name="model">
			   <row>
			    <label value="\${each}" />
			   </row>
			  </template>
			 </grid>
			 <button id="btnOne" label="reset" onClick="grid.setModel(model)"/>
			 </window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-row:contains(D)")[0])())
		.ok("The grid should rendered (not exception page)");
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("Should no exception alert window");
});
