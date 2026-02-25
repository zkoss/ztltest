import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1664TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1664TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<zscript><![CDATA[
import java.util.ArrayList;
import org.zkoss.zul.*;
ArrayList list = new ArrayList();
for (int i = 0; i < 10; i++) {
	list.add("row " + i);
}
ListSubModel model = ListModels.toListSubModel(new ListModelList(list));
]]></zscript>
	<label multiline="true">
	1. Type \'r\' in the input chosenbox, and select any one from drop down list.
	2. Type \'r\' again, if you don\'t see the drop down list, it is a bug.
	</label>
    <chosenbox id="lbxThree" width="300px" model="\${model}"
    	emptyMessage=" Please select some items." 
    	noResultsText=" No such item - {0} - and it is already in the model."
    	createMessage=" No such item -{0} - but it is not in model either, you can try to create it.">
    </chosenbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-chosenbox-input")[0]));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-chosenbox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-chosenbox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("r");
	await ztl.waitResponse(t);
	await t
		.wait(2000)
		.click(Selector(() => jq(".z-chosenbox-option:contains(row 4)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-input")[0]));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-chosenbox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-chosenbox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("r");
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-chosenbox-option:contains(row 6)")[0],
			)(),
		)
		.ok("you should see the drop down list");
});
