import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-940TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-940TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <div>
          Select Listitem/Treeitem 1. You should NOT see any of other Listitems/Treeitems selected. Otherwise this is a bug.
        </div>
        <div>
          When you hover Listitem/Treeitem 1, the checkmark of other Listitems/Treeitems should NOT reflect hover state (blue color).
        </div>
        <div>
          Note that due to CSS limitation, we are skipping the fix for IE 6. (We can fix it by adding CSS class, but probably not worth it.)
        </div>
        <listbox multiple="true" checkmark="true">
          <listitem>
            <listcell>
              Listitem 1
              <listbox multiple="true" checkmark="true">
                <listitem label="Listitem 2"/>
                <listitem label="Listitem 3"/>
              </listbox>
              <listbox checkmark="true">
                <listitem label="Listitem 4"/>
                <listitem label="Listitem 5"/>
              </listbox>
            </listcell>
          </listitem>
        </listbox>
        <tree multiple="true" checkmark="true">
          <treechildren>
            <treeitem>
              <treerow>
                <treecell>
                  Treeitem 1
                  <tree multiple="true" checkmark="true">
                    <treechildren>
                      <treeitem label="Treeitem 2"/>
                      <treeitem label="Treeitem 3"/>
                    </treechildren>
                  </tree>
                  <tree checkmark="true">
                    <treechildren>
                      <treeitem label="Treeitem 4"/>
                      <treeitem label="Treeitem 5"/>
                    </treechildren>
                  </tree>
                </treecell>
              </treerow>
            </treeitem>
          </treechildren>
        </tree>
      </zk>`,
	);
	await t.click(Selector(() => jq(".z-listitem:contains(Listitem 1)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-listitem .z-listitem").hasClass("z-listitem-seld"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0)
		.notOk("should NOT see any of other Listitems/Treeitems selected.");
	await t.hover(Selector(() => jq(".z-listitem:contains(Listitem 1)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-listitem .z-listitem").hasClass("z-listitem-over"),
	)();
	await t
		.expect(verifyVariable_cafe_1_1)
		.notOk(
			"the checkmark of other Listitems/Treeitems should NOT reflect hover state (blue color).",
		);
	await t.click(Selector(() => jq(".z-treerow:contains(Treeitem 1)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(".z-treerow .z-treerow").hasClass("z-treerow-seld"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0t)
		.notOk("should NOT see any of other Listitems/Treeitems selected.");
	await t.hover(Selector(() => jq(".z-treerow:contains(Treeitem 1)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(".z-treerow .z-treerow").hasClass("z-treerow-over"),
	)();
	await t
		.expect(verifyVariable_cafe_1_1t)
		.notOk(
			"the checkmark of other Listitems/Treeitems should NOT reflect hover state (blue color).",
		);
});
