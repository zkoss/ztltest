import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2149511TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2149511TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2149511.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct  7 09:02:04     2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk
	xmlns="http://www.zkoss.org/2005/zul"
	xmlns:h="http://www.w3.org/1999/xhtml">

<window>
  
  <h:ol>
  <h:li>Open \'Item 1.a\'</h:li>
  <h:li>Open \'Item 2.a\' and \'Item 3.a\'</h:li>
  <h:li>Scroll down to \'23.A\' and open it - notice that the tree has scrolled to top(That is wrong)</h:li>
  </h:ol>

		<zscript><![CDATA[

	int counter = 3;

	EventListener aa = new EventListener()
	{
	  public void onEvent(Event event)
	  {
	    autoAdd( event.target );
	  }
	};

	void autoAdd(Treeitem parent)
	{
		if ( parent.empty )
		{
			parent.removeEventListener( "onOpen", aa );

			for (int i=0; i < 10; i++)
			{
				Treeitem ti = new Treeitem();
				Treerow  tr = new Treerow();
				String   c  = Integer.toString( ++counter );
    			
    			tr.setId("i"+c+"A");
				tr.appendChild( new Treecell( c + ".A" ) );
				tr.appendChild( new Treecell( c + ".B" ) );
				tr.appendChild( new Treecell( c + ".C" ) );
				tr.appendChild( new Treecell( c + ".D" ) );
	
				ti.appendChild( tr );
				parent.treechildren.appendChild( ti );

				ti.setOpen(false);
				ti.setTooltiptext( "Node " + c );
				ti.addEventListener( "onOpen", aa );
				ti.appendChild( new Treechildren() );
			}
		}
	}
	]]></zscript>


		<tree
			id="tree"
			pageSize="-1"
			rows="20" >
			<treecols>
				<treecol label="A" />
				<treecol label="B" />
				<treecol label="C" />
				<treecol label="D" />
			</treecols>
			<treechildren>
				<treeitem 
					open="false"
					onOpen="if (event.open) autoAdd(self)">
					<treerow id="i1a">
						<treecell label="Item 1.a" />
						<treecell label="Item 1.b" />
						<treecell label="Item 1.c" />
						<treecell label="Item 1.d" />
					</treerow>
					<treechildren>
						<treeitem 
							open="false"
							onOpen="if (event.open) autoAdd(self)">
							<treerow id="i2a">
								<treecell label="Item 2.a" />
								<treecell label="Item 2.b" />
								<treecell label="Item 2.c" />
								<treecell label="Item 2.d" />
							</treerow>
							<treechildren />
						</treeitem>
						<treeitem 
							open="false"
							onOpen="if (event.open) autoAdd(self)">
							<treerow id="i3a" >
								<treecell label="Item 3.a" />
								<treecell label="Item 3.b" />
								<treecell label="Item 3.c" />
								<treecell label="Item 3.d" />
							</treerow>
							<treechildren />
						</treeitem>
					</treechildren>
				</treeitem>
			</treechildren>
		</tree>

	</window>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("$i1a")).$n("open")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("$i2a")).$n("open")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("$i3a")).$n("open")));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("$tree")).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:contains(23.A)")).$n("open")),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$tree")).$n("body")).scrollTop(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 40).ok();
});
