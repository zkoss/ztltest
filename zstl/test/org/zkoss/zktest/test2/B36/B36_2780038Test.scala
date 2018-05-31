/* B36_2780038Test.java

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


class B36_2780038Test extends ZTL4ScalaTestCase {
  @Test
  def testicon() = {
    var zscript =
      """
			<zk>
				Please check both images showing by pressing the two button.
				<button label="Zhtml click" onClick='org.zkoss.zul.Messagebox.show("are you sure to quit?","title",16|32,org.zkoss.zhtml.Messagebox.INFORMATION);'/>
				<button label="zul click" onClick='org.zkoss.zul.Messagebox.show("are you sure to quit?","title",16|32,org.zkoss.zul.Messagebox.INFORMATION);'/>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@button[label=\"Zhtml click\"]"))
      waitResponse()
      var zHtmlClass = jq(".z-mssagebox-window").attr("class")
      click(jq("@window.z-window-highlighted").toWidget().$n("close"))
      waitResponse()
      click(jq("@button[label=\"zul click\"]"))
      waitResponse()
      var zulClass = jq(".z-mssagebox-window").attr("class")
      click(jq("@window.z-window-highlighted").toWidget().$n("close"))
      verifyEquals(zHtmlClass, zulClass)
    })
  }
}



