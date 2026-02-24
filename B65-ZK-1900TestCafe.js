import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1900TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1900TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await ztl.runZscript(
		t,
		`<zk>
	<zscript><![CDATA[
		class ItemComparator implements Comparator {
			public int compare(Object text, Object label) {
			    String val = text.toString().toLowerCase();
		
			    if (val.isEmpty()) return 0;
			    return label.toString().toLowerCase().startsWith(val)? 0: -1;
			}
		}
		
		List list = new ArrayList();
		list.add("01");
		list.add("02");
		list.add("03");
		ListModel model = ListModels.toListSubModel(
				new ListModelList(list), new ItemComparator(), 10);
	]]></zscript>
	When scroll combobox to the bottom and type "01", the dropdown should apears above it and have no blank. 
	<div height="900px"></div>
	<combobox model="\${model}" 
		autodrop="true" autocomplete="false">
	</combobox>
</zk>`,
	);
	await ClientFunction(() => {
		jq("body")[0].scrollTop = 1000;
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-combobox")).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("0 1");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(zk.Widget.$(jq(".z-combobox"))).offset().top,
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 + verifyVariable_cafe_1_1 <=
				verifyVariable_cafe_2_2,
		)
		.ok("the dropdown should apears above it");
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("pp"))
					.find(".z-comboitem:contains(01)")
					.is(":visible"),
			)(),
		)
		.ok("the dropdown should have no blank");
});
