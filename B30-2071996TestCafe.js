import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2071996TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2071996TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Press next page twice to go to the last page
	Then, check if all listitem can be selected (by moving mouse over them and click upon it).
	<zscript>
	String[] data = new String[] {
		"Albert", "Bob", "Candy", "Elva", "Elva2", "Gaby", "Gavin", "Jason",
		"John", "Jean", "Janet", "Jamie", "Jessica", "Peter",
		"Rex", "Richard", "Sam", "Sidney", "Simon", "Sky", "Tony", "Vicky",
		"Winnie", "Wendy", "Zera", "Zenobia" };
	ListModel strset = new SimpleListModel(data);
	</zscript>
	<listbox id="search" model="&#36;{strset}" />
	<paging onCreate=\'search.setMold("paging");search.paginal=self;search.pageSize=10;\' />
</zk>`,
	);
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@listitem:eq(1)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@listitem:eq(1)").hasClass("z-listitem-selected"),
	)();
	await t.expect(verifyVariable_cafe_0_0).ok();
	await t.click(Selector(() => jq("@listitem:eq(2)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq("@listitem:eq(2)").hasClass("z-listitem-selected"),
	)();
	await t.expect(verifyVariable_cafe_0_0t).ok();
	await t.click(Selector(() => jq("@listitem:eq(3)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq("@listitem:eq(3)").hasClass("z-listitem-selected"),
	)();
	await t.expect(verifyVariable_cafe_0_0tt).ok();
	await t.click(Selector(() => jq("@listitem:eq(4)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq("@listitem:eq(4)").hasClass("z-listitem-selected"),
	)();
	await t.expect(verifyVariable_cafe_0_0ttt).ok();
	await t.click(Selector(() => jq("@listitem:eq(5)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq("@listitem:eq(5)").hasClass("z-listitem-selected"),
	)();
	await t.expect(verifyVariable_cafe_0_0tttt).ok();
});
