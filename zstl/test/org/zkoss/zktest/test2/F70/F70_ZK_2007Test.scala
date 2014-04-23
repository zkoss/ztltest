package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2007.zul")
class F70_ZK_2007Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window title="Toggle Popup" border="normal" width="500px" height="300px">
	<label multiline="true">
	1. Right click Item will open the popup, click again it will close.
	2. Left click Item1 will open the context menu, click again it will close.
	3. Right click Item2 will open the context menu, click again it will close.
	</label>
	<tree context="tc, type=toggle">
			<treecols sizable="false">
				<treecol/>
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item"/>
					</treerow>
					<treechildren>
						<treeitem popup="mp, type=toggle">
							<treerow>
								<treecell label="Item1"/>
							</treerow>
							<treechildren>
								<treeitem context="mc, type=toggle">
									<treerow>
										<treecell label="Item2"/>
									</treerow>
								</treeitem>
							</treechildren>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell label="Item"/>
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
			</treechildren>
		</tree>
	<popup id="tc">
		<label value="Tree Context"/>
	</popup>
	<menupopup id="mp">
		<menuitem label="Tree1 Popup"/>
        <menu label="Next">
	        <menupopup>
	            <menuitem label="Tree11 Popup"/>
	            <menuitem label="Tree12 Popup"/>
	        </menupopup>
         </menu>
	</menupopup>
	<menupopup id="mc">
		<menuitem label="Tree2 Context"/>
        <menu label="Next">
	        <menupopup>
	            <menuitem label="Tree21 Context"/>
	            <menuitem label="Tree22 Context"/>
	        </menupopup>
         </menu>
	</menupopup>
</window>"""  
  runZTL(zscript,
    () => {
      val item = jq(".z-treerow:contains(Item)")
      val item1 = jq(".z-treerow:contains(Item1)")
      val item2 = jq(".z-treerow:contains(Item2)")
      contextMenu(item)
      waitResponse()
      verifyTrue("open the popup", jq(".z-popup").exists)
      
      contextMenuAt(item, "0,0")
      waitResponse()
      verifyTrue("it will close", !jq(".z-popup").isVisible())
      
      click(item1)
      waitResponse()
      verifyTrue("open the context menu", jq(".z-menupopup").exists)
      clickAt(item1, "0,0")
      waitResponse()
      verifyTrue("it will close", !jq(".z-menupopup").isVisible())
      
      contextMenu(item2)
      waitResponse()
      verifyTrue("open the context menu", jq(".z-menupopup").exists)
      
      contextMenuAt(item2, "0,0")
      waitResponse()
      verifyTrue("it will close", !jq(".z-menupopup").isVisible())
    })
    
  }
}