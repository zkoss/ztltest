/* B30_2105802Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_2105802Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Trees" border="normal">
When you click the "Add/Remove Child" button, and then the treeitem's icon should disappear. 
<tree id="tree" width="90%" rows="5">
<treecols sizable="true">
<treecol label="Name"/>
<treecol label="Description"/>
</treecols>
<treechildren>
<treeitem id="ti">
<treerow id="tr">
<treecell label="Item 1"/>
<treecell label="Item 1 description"/>
</treerow>
</treeitem>
</treechildren>
</tree>
<button onClick="addRemove()" label="Add/Remove Child"/>
<zscript>
addRemove() {
tc2=new Treechildren();
tc2.parent=ti;
Messagebox.show("Added..., and you should see the arrow icon on the treeitem.", null, Messagebox.OK, Messagebox.INFORMATION, 0, new EventListener() {
public void onEvent(Event event) throws Exception {
tc2.detach();
alert("Removed..., and you shouldn't see the arrow icon");
}
});

}
</zscript>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val ti = ztl$engine.$f("ti")
    val tr = ztl$engine.$f("tr")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq(".z-tree-icon").exists())
      clickAlert()
      waitResponse()
      verifyFalse(jq(".z-tree-icon").exists())
    })
  }
}



