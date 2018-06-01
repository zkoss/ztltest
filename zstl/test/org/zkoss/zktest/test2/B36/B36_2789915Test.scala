/* B36_2789915Test.java

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


class B36_2789915Test extends ZTL4ScalaTestCase {
  @Test
  def testimg() = {
    var zscript =
      """
			<zk>
			Please press upon the MSN icon to reset the hoverIamge, and then move the mouse out the button, you should see a defender image.
			<toolbar width="200px" id="tb" sclass="vista" height="20px"
			align="end">
			<toolbarbutton id="toolbarbutton1" image="/img/live.gif"
			disabled="false" hoverImage="/img/network.gif"
			
			onClick='toolbarbutton1.setDisabled(!toolbarbutton1.isDisabled());
			if (toolbarbutton1.isDisabled()) {
			
			toolbarbutton1.setImage("/img/defender.gif");
			
			toolbarbutton1.setHoverImage(null);
			} else {
			
			toolbarbutton1.setImage("/img/live.gif");
			}' />
			</toolbar>
			</zk> 
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val toolbarbutton1 = ztl$engine.$f("toolbarbutton1")
    runZTL(zscript, () => {
      mouseOver(toolbarbutton1)
      click(toolbarbutton1)
      waitResponse()
      mouseOut(toolbarbutton1)
      verifyTrue(jq(toolbarbutton1).find("img").attr("src").indexOf("defender") > 1)
    })
  }
}


