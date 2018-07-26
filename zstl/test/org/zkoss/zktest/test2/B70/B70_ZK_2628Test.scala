package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2628.zul")
class B70_ZK_2628Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2628.zul

	Purpose:
		
	Description:
		
	History:
		Mon Aug  3 12:25:47 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  <window border="normal" title="Combobox with Icons should be showing">
	  <vbox>

		  Combobox without icon:
		  <combobox>
			  <comboitem  label="Simple and Rich" />
			  <comboitem  label="Cool!" />
			  <comboitem  label="Thumbs Up!" />
		  </combobox>
		  Combobox:
		  <combobox>
			  <comboitem  iconSclass="z-icon-caret-down" label="Simple and Rich" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Cool!" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Thumbs Up!" />
		  </combobox>
		  Combobox with description:
		  <combobox>
			  <comboitem  iconSclass="z-icon-caret-down" label="Simple and Rich"
						 description="The simplest way to make Web applications rich" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Cool!"
						 description="The coolest technology" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Ajax and RIA"
						 description="Rich Internet Application by Ajax" />
		  </combobox>
		  Combobox with description and icons:
		  <combobox>
			  <comboitem  iconSclass="z-icon-caret-down" label="Simple and Rich" image="/img/Centigrade-Widget-Icons/GoldBar-32x32.gif"
						 description="The simplest way to make Web applications rich" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Cool!" image="/img/Centigrade-Widget-Icons/CogwheelEye-32x32.gif"
						 description="The coolest technology" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Ajax and RIA" image="/img/Centigrade-Widget-Icons/WindowGlobe-32x32.gif"
						 description="Rich Internet Application by Ajax" />
		  </combobox>
	  </vbox>
   
  </window>
</zk>

"""
    runZTL(zscript,
      () => {
        //open the 1st combobox
        click(jq(".z-combobox-button").eq(0))
        waitResponse()
        //check the combobox popup menu have only text
        verifyNotEquals(jq(".z-combobox-popup.z-combobox-open .z-comboitem-text").eq(0).text(), "")
        verifyFalse(jq(".z-combobox-popup.z-combobox-open .z-comboitem-image").eq(0).children().exists())
        //close the 1st combobox
        click(jq(".z-combobox-button").eq(0))
        waitResponse()
        //open the 2nd combobox
        click(jq(".z-combobox-button").eq(1))
        waitResponse()
        //check the combobox popup menu have text and icon
        verifyNotEquals(jq(".z-combobox-popup.z-combobox-open .z-comboitem-text").eq(0).text(), "")
        verifyTrue(jq(".z-combobox-popup.z-combobox-open .z-comboitem-icon").eq(0).children().exists())
        //close the 2nd combobox
        click(jq(".z-combobox-button").eq(1))
        waitResponse()
        //open the 3rd combobox
        click(jq(".z-combobox-button").eq(2))
        waitResponse()
        //check the combobox popup menu have text and icon
        verifyNotEquals(jq(".z-combobox-popup.z-combobox-open .z-comboitem-text").eq(0).text(), "")
        verifyTrue(jq(".z-combobox-popup.z-combobox-open .z-comboitem-icon").eq(0).children().exists())
        //close the 3rd combobox
        click(jq(".z-combobox-button").eq(2))
        waitResponse()
        //open the 4th combobox
        click(jq(".z-combobox-button").eq(3))
        waitResponse()
        //check the combobox popup menu have text, icon, and image
        verifyNotEquals(jq(".z-combobox-popup.z-combobox-open .z-comboitem-text").eq(0).text(), "")
        verifyTrue(jq(".z-combobox-popup.z-combobox-open .z-comboitem-icon").eq(0).children().exists())
        verifyTrue(jq(".z-combobox-popup.z-combobox-open .z-comboitem-image").eq(0).children().exists())
        //close the 4th combobox
        click(jq(".z-combobox-button").eq(3))
        waitResponse()
      })
  }
}