/* B50_3049181Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3049181Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	1. Open the bandbox and then check the checkbox (IE6 only)
	<separator/>
	2. Reopen again, the checkbox should be checked.
<bandbox id="bb" width="650px" readonly="true">
<bandpopup >
<vbox>
<tree id="tree" width="400px" >
<treecols sizable="true">
<treecol label="Name" />
</treecols>
<treechildren>
<treeitem>
<treerow>
<treecell >
<checkbox id="testCheck" label="asdasd" />
</treecell>
</treerow>
</treeitem>
</treechildren>
</tree>
<button label="Check State in Tree" onClick="check(testCheck.checked)" />
<zscript>
public void check(boolean val) {
checkVal.setText(" "+ val);
}
</zscript>
<textbox id="checkVal" />
</vbox>
</bandpopup >
</bandbox> 
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val bb = ztl$engine.$f("bb")
    val tree = ztl$engine.$f("tree")
    val testCheck = ztl$engine.$f("testCheck")
    val checkVal = ztl$engine.$f("checkVal")
    runZTL(zscript, () => {
      click(bb.$n("btn"));
      waitResponse()
      click(testCheck.$n("real"));
      waitResponse()
      click(bb.$n("btn"));
      waitResponse()
      click(bb.$n("btn"));
      waitResponse()
      verifyTrue(isChecked(testCheck.$n("real")))
    })
  }
}



