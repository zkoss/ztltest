/* B30_1823218Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1823218Test extends ZTL4ScalaTestCase {
  @Test
  def testLayout() = {
    var zscript =
      """
<zk xmlns:h="http://www.w3.org/1999/xhtml">
	<h:h3> [ 1823218 ] Tree with vflex, body grows over boarder.</h:h3>
	<h:pre>
Tree with vflex, body grows over boarder.
Notice: This only happens when there is tree columns
	</h:pre>
	<window border="normal" height="300px"> 
		<tree id="tree" width="400px" vflex="true">
			<treecols id="cols">
				<treecol label="Header"/>
			</treecols>
		</tree>
		<button id="btn1" label="remove header" onClick="cols.setParent(null)" />
		LALLALALALALALAL
	</window> 
</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val cols = ztl$engine.$f("cols")
    val btn1 = ztl$engine.$f("btn1")
    runZTL(zscript, () => {
      verifyTrue(jq(tree.$n("body")).offsetTop() <=
        jq(tree.$n("head")).offsetTop() + jq(tree.$n("head")).height())
      click(btn1)
      waitResponse()
      verifyEquals(jq(tree).width(), jq(tree.$n("body")).outerWidth())
      verifyEquals(jq(tree).height(), jq(tree.$n("body")).outerHeight())
    })
  }
}



