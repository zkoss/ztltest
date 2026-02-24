import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3317743TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3317743TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>1. Click on item 3.</div>
				<div>2. Go to next page.</div>
				<div>3. Click on item 8, but on the blank, NOT on the checkmark.</div>
				<div>4. Go back to page 1. If item 3 is deselected, it is a bug.</div>
				<zscript><![CDATA[
					ListModelList m = new ListModelList();
					for(int i = 0; i < 20; i++)
						m.add(i);
    				m.setMultiple(true);
				]]></zscript>
				<listbox id="listbox" onClick="tb.setValue(event.getPageX().toString())" multiple="true" model="\${m}" checkmark="true"
					mold="paging" onCreate="self.setPageSize(5)" />
    			<textbox id="tb" />
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("listbox", true).$n("rows")).find(
					".z-listitem",
				)[3],
		),
		{ offsetX: 200, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("listbox", true).$n("rows")).find(
					".z-listitem",
				)[3],
		),
		{ offsetX: 200, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() => zk.Desktop._dt.$f("tb", true).$n().value)(),
	);
	await t.expect(verifyVariable_cafe_0_0 > 200).ok();
	await t.click(Selector(() => jq("@paging").find(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-listitem:eq(3)").hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
});
