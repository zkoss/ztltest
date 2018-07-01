package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2268.zul")
class B70_ZK_2268Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2268.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Jul 23, 2015  3:47:34 PM, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<window height="100%" width="100%" position="center, center">
		<label multiline="true">
			1.press button
			2.press the two buttons (IE 8~10)
			3.you should see the second popup messagebox on the topmost
		</label>
		<button label="Open Modal Window">
			<attribute name="onClick">
				((Window) Executions.createComponents("/test2/B70-ZK-2268-1.zul",self.getParent(),null)).doModal();
			</attribute>
		</button>
	</window>
</zk>


"""
    runZTL(zscript,
      () => {
        //open modal window
        click(jq("button").eq(0))
        waitResponse()
        //click the left button in the 1st popup
        click(jq(".z-toolbarbutton"))
        waitResponse()
        //dismiss the 2nd popup, if the popup is not the top most, there will be exceptions
        click(jq(".z-messagebox-button.z-button"))
        waitResponse()
        //click the right button in the 1st popup
        click(jq(".z-button").eq(1))
        waitResponse()
        //dismiss the 2nd popup, if the popup is not the top most, there will be exceptions
        click(jq(".z-messagebox-button.z-button"))
        waitResponse()
      })
  }
}