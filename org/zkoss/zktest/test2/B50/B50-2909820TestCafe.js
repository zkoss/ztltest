import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2909820TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2909820TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    Please click upon "Item 2", and then click the "addChild" button.
    <separator/>
    You should see the item "Item 2.3.1" is added after "Item 2.2.1", rather
than after "Item 2.2"
    <tree id="tree" width="400px" rows="8">
        <treecols sizable="true">
            <treecol label="Name" />
            <treecol label="Description" align="right" />
        </treecols>
        <treechildren>
            <treeitem>
                <treerow>
                    <treecell label="Item 1" />
                    <treecell label="Item 1 description"/>
                </treerow>
            </treeitem>
            <treeitem>
                <treerow>
                    <treecell label="Item 2" />
                    <treecell label="Item 2 description" />
                </treerow>
                <treechildren>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.1" />
                        </treerow>
                        <treechildren>
                            <treeitem>
                                <treerow>
                                    <treecell label="Item 2.1.1" />
                                </treerow>
                            </treeitem>
                            <treeitem>
                                <treerow>
                                    <treecell label="Item 2.1.2" />
                                </treerow>
                            </treeitem>
                        </treechildren>
                    </treeitem>
                    <treeitem>
                        <treerow>
                            <treecell label="Item 2.2" />
                        </treerow>
                        <treechildren>
                            <treeitem>
                                <treerow>
                                    <treecell label="Item 2.2.1" />
                                </treerow>
                            </treeitem>
                        </treechildren>
                    </treeitem>
                </treechildren>
            </treeitem>
            <treeitem label="Item 3" />
        </treechildren>
    </tree>
    <button label="addChild">
        <attribute name="onClick">
            Treeitem ti = tree.getSelectedItem();
Treechildren tcn = ti.getTreechildren();
Treeitem tempnew = new Treeitem();
Treechildren tcnnew = new Treechildren();
tcnnew.setParent(tempnew);
Treerow tr = new Treerow();
Treecell tc1 = new Treecell("Item 2.3.1");
Treecell tc2 = new Treecell("10000");
tr.setParent(tempnew);
tc1.setParent(tr);
tc2.setParent(tr);
tempnew.setParent(tcn);


        </attribute>
    </button>
</zk>`,
	);
	await t.click(Selector(() => jq('@treecell[label="Item 2.2"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@treecell[label="Item 2.3.1"]').parent().html(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@treecell[label="Item 2.2.1"]').parent().next().html(),
				)(),
			),
		);
});
