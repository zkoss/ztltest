import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1711TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1711TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. Click "invalidate" button.
	2. If drop-down list of "Chosenbox" and "Selectbox" is empty, it is a bug. 
	</label>
	<window id="win" width="100%">
		<zscript>
			ListModelList model = new ListModelList();
			model.add("test1");
			model.add("test2");
		</zscript>
		Chosen Box: <chosenbox id="chosenbox" width="100px" model="\${model}" />
		Select Box: <selectbox model="\${model}" />
		<button label="invalidate" onClick="win.invalidate()" />
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(invalidate)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-chosenbox-option").length,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("option").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 2 && verifyVariable_cafe_1_1 == 2)
		.ok(
			"the drop-down list of 'Chosenbox' and 'Selectbox' should not be empty ",
		);
});
