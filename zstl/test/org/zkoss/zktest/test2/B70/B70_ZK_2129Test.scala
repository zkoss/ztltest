package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2129.zul")
class B70_ZK_2129Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="Colum headers height native scrollbar" contentType="text/html;charset=UTF-8"?>
<zk>
	<label value="Scroll to the right bound, height of the tree won't be changed"/>
	<tree height="125px" width="300px" rows="8">
	    <custom-attributes org.zkoss.zul.nativebar="true"/>
	    <frozen columns="1"/>
	    <treecols sizable="false">
	    	<treecol width="100px" label="Fixed Column"/>
	    	<treecol width="70px" label="column_1">
	    		<div><label value="multi-line"/></div>
	    	</treecol>
	    	<treecol width="70px" label="column_2">
	    		<div><label value="multi-line"/></div>
	    	</treecol>
	    	<treecol width="70px" label="column_3">
	    		<div><label value="multi-line"/></div>
	    	</treecol>
	    	<treecol hflex="1"/>
	    </treecols>
      	<treechildren>
      		<treeitem></treeitem>
    	</treechildren>
	</tree>
</zk>"""  
  runZTL(zscript,
    () => {
      val tree = jq(".z-tree")
      val h = tree.height()
      nativeFrozenScroll(tree, 200)
      
      verifyTrue("height of the tree won't be changed", h == tree.height())
    })
    
  }
}