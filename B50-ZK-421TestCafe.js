import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-421TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-421TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    			<div>1. Select an item, go to page 2.</div>
    			<div>2. Select another item and go back to page 1. In the first Listbox you 
    				should see no item selected in the first page. For the second Listbox, the item 
    				shall remain selected unless the Library properties "checkmarkDeselectsOther" is true.</div>
    				Multiple:
    			<listbox id="lb1" mold="paging" multiple="true" onCreate="self.setPageSize(5)">
    				<listitem label="\${each}" forEach="1,2,3,4,5,6,7,8,9,10" />
    			</listbox>
    			Multiple, Checkmark:
    			<listbox id="lb2" mold="paging" multiple="true" checkmark="true" onCreate="self.setPageSize(5)">
    				<listitem label="\${each}" forEach="1,2,3,4,5,6,7,8,9,10" />
    			</listbox>
    		</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("lb1", true).$n("rows")).find(
					".z-listitem",
				)[2],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(zk.Desktop._dt.$f("lb1", true)).find(".z-paging-next")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("lb1", true).$n("rows")).find(
					".z-listitem",
				)[2],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("lb1", true))
					.find(".z-listitem:eq(2)")
					.hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("lb1", true)).find(
					".z-paging-previous",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("lb1", true))
					.find(".z-listitem:eq(2)")
					.hasClass("z-listitem-selected"),
			)(),
		)
		.notOk();
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("lb2", true).$n("rows")).find(
					".z-listitem",
				)[2],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(zk.Desktop._dt.$f("lb2", true)).find(".z-paging-next")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("lb2", true).$n("rows")).find(
					".z-listitem",
				)[2],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("lb2", true))
					.find(".z-listitem:eq(2)")
					.hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("lb2", true)).find(
					".z-paging-previous",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("lb2", true))
					.find(".z-listitem:eq(2)")
					.hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
});
