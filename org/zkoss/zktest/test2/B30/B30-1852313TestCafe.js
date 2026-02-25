import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1852313TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1852313TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk
                xmlns="http://www.zkoss.org/2005/zul"
                xmlns:h="http://www.w3.org/1999/xhtml"
                xmlns:n="http://www.zkoss.org/2005/zk/native">
                <n:h3>Open any Tree node (just once), the browser should NOT have any javascript error!</n:h3>
                <n:h3>If the layout look incorrect, it is a normal result.</n:h3>

                <window>

                    <zscript><![CDATA[

                    int counter = 3;
                    String az = "The quick brown fox jumped over the lazy dog";
                    Random r = new Random();

                    EventListener aa = new EventListener()
                    {
                        public void onEvent(Event event)
                        {
                            autoAdd( event.target );
                        }
                    };

                    void autoAdd(Treeitem parent)
                    {
                        if ( parent.treechildren == null )
                            parent.appendChild( new Treechildren() );

                        if ( !parent.empty )
                            return;

                        for (int i=0; i < 10; i++)
                        {
                            Treeitem ti = new Treeitem();
                            Treerow  tr = new Treerow();
                            String   c  = Integer.toString( ++counter );

                            for ( int x=0 ; x < 4 ; x++ )
                            {
                                switch ( r.nextInt() % 3 )
                                {
                                    case 0: createLabelCell (c).setParent(tr); break;
                                    case 1: createDoubleCell(counter).setParent(tr);
                                    case 2: createLabelCell (az).setParent(tr); break;
                                }
                            }

                            tr.setParent(ti);
                            ti.setOpen(false);
                            ti.appendChild( new Treechildren() );
                            ti.addEventListener( "onOpen", aa );
                            ti.setParent( parent.treechildren );
                        }
                    }

                    Treecell createDoubleCell( Double x )
                    {
                        Treecell tc = new Treecell();
                        tc.appendChild( new Doublebox( x ) );
                        return tc;
                    }
                    Treecell createLabelCell( String x )
                    {
                        Treecell tc = new Treecell();
                        tc.appendChild( new Label( x ) );
                        return tc;
                    }       
                    ]]></zscript>


                    <tree
                        id="tree"
                        rows="30"
                        width="100%"
                        pageSize="-1">
                        <treecols>
                            <treecol label="A" />
                            <treecol label="B" />
                            <treecol label="C" />
                            <treecol label="D" />
                        </treecols>
                        <treechildren>
                            <treeitem open="false" onOpen="if (event.open) autoAdd(self)">
                                <treerow>
                                    <treecell label="Item 1.a" />
                                    <treecell label="Item 1.b" />
                                    <treecell label="Item 1.c" />
                                    <treecell label="Item 1.d" />
                                </treerow>
                                <treechildren />
                            </treeitem>
                            <treeitem open="false" onOpen="if (event.open) autoAdd(self)">
                                <treerow>
                                    <treecell label="Item 2.a" />
                                    <treecell label="Item 2.b" />
                                    <treecell label="Item 2.c" />
                                    <treecell label="Item 2.d" />
                                </treerow>
                                <treechildren />
                            </treeitem>
                            <treeitem open="false" onOpen="if (event.open) autoAdd(self)">
                                <treerow>
                                    <treecell label="Item 3.a" />
                                    <treecell label="Item 3.b" />
                                    <treecell label="Item 3.c" />
                                    <treecell label="Item 3.d" />
                                </treerow>
                                <treechildren />
                            </treeitem>
                        </treechildren>
                    </tree>

               </window>
            </zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("@treerow:eq(0)")).$n("icon")));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(
		Selector(() =>
			zk.Widget.$(jq("@treerow:eq(0)").find("@treerow")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Widget.$(jq("@treerow:eq(0)")).$n("icon")));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Widget.$(jq("@treerow:eq(0)")).$n("icon")));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
