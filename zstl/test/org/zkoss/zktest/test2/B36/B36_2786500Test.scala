/* B36_2786500Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B36_2786500Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
				<label id="desp" value="Please press both labels, and they should work well." />
				<vbox>
				<label id="label1" value="Click 1" onClick="title.open(title)"
				/>
				<label id="label2" value="Click 2" popup="title" />
				</vbox>
				<menupopup id="title" >
				<menuitem label="test"/>
				</menupopup>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val desp = ztl$engine.$f("desp")
    val label1 = ztl$engine.$f("label1")
    val label2 = ztl$engine.$f("label2")
    val title = ztl$engine.$f("title")
    runZTL(zscript, () => {
      var labels = jq("@label")
      var menuitem = jq("@menuitem")
      click(jq(label1))
      waitResponse()
      verifyTrue(menuitem.isVisible())
      clickAt(desp, "80,3")
      waitResponse()
      verifyFalse(menuitem.isVisible())
      click(labels.get(2))
      waitResponse()
      verifyTrue(menuitem.isVisible())
    })
  }
}



