import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1604TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1604TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
		1.click "setOld" button, you should not see with any js error. 
	</label>
	<zscript><![CDATA[
	ListModelList model = new ListModelList();
	model.add("A");
	model.add("B");
	model.add("C");
	
	void setModelOld(){
		ListModelList model = lb.getModel();
		lb.setModel(model);
	}
	]]></zscript>
	<button label="setOld" onClick="setModelOld()"/>
	<borderlayout width="300px" height="300px">
		<center flex="true">
			<columnlayout>
				<columnchildren hflex="1">
					<listbox id="lb" model="\${model}" hflex="1">
						<template name="model">
							<listitem label="\${each}"/>
						</template>
					</listbox>
				</columnchildren>
			</columnlayout>
		</center>
	</borderlayout>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(setOld)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
