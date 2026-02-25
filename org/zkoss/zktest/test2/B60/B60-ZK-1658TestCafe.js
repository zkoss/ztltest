import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1658TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1658TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<zscript><![CDATA[
	import java.util.*;
	import org.zkoss.zul.*;
	List listShop = new ArrayList();
	for (int i = 0; i < 100; i++)
		listShop.add("SHOP - " + i);
	ListModelList model = new ListModelList(listShop);
	ListSubModel submodel = (ListSubModel) ListModels.toListSubModel(model);
	]]></zscript>
	<window title="Chosen Box" border="normal">
		<label multiline="true">
		1. Type "S" in the input, and select one item.
		2. If you see the component disappeared, it is a bug.
		</label>
		<chosenbox id="cb" model="\${submodel}" width="400px" noResultsText="No such item - {0}" />
	</window>
</zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq(".z-chosenbox-input"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-chosenbox-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("S");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-option:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-chosenbox-input")[0])())
		.ok("the component should not disappear");
});
