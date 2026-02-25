import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-840TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-840TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>
                      1. There should be no javascript error on loading
                    </div>
                    <div>
                      2. Open the Treeitem in the last Tree. You should see no javascript error
                    </div>
                    <grid hflex="min">
                      <rows>
                        <row>Row 1</row>
                      </rows>
                      <foot>
                        <footer label="Footer 1"/>
                      </foot>
                    </grid>
                    <listbox hflex="min">
                      <listitem label="Item 1"/>
                      <listfoot>
                        <listfooter label="Footer 1"/>
                      </listfoot>
                    </listbox>
                    <tree hflex="min">
                      <treechildren>
                        <treeitem label="Item 1"/>
                      </treechildren>
                      <treefoot>
                        <treefooter label="Footer 1"/>
                      </treefoot>
                    </tree>
                    <tree width="300px" height="300px">
                      <treecols>
                        <treecol label="Header 1"/>
                      </treecols>
                      <treechildren>
                        <treeitem label="Item 1" open="false">
                          <treechildren>
                            <treeitem label="Item 2"/>
                          </treechildren>
                        </treeitem>
                      </treechildren>
                      <treefoot>
                        <treefooter label="Footer 1"/>
                      </treefoot>
                    </tree>
                  </zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(".z-tree:contains(Header) .z-treerow:contains(Item)"),
			).$n("icon"),
		),
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
