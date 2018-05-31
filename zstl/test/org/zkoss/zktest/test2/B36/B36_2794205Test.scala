/* B36_2794205Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget;

class B36_2794205Test extends ZTL4ScalaTestCase {
  @Test
  def testposition() = {
    var zscript =
      """
			<zk>
			1. Click the button "Click Me!", and then click the dropdown list, the
			error box should not move away(IE 6 only).
			<vbox>
			<listbox id="myDropdownList" rows="1" mold="select">
			<listitem label="" value="" selected="true"/>
			<listitem label="zk" value="Direct RIA"/>
			<listitem label="ajax" value="Asynchronous"/>
			
			</listbox>
			<button onClick="showValue()" label="Click Me!"/>
			</vbox>
			
			<zscript>
			void showValue() {
			if
			(String.valueOf(myDropdownList.getSelectedItem().getValue()).equals("")) {
			throw new WrongValueException(myDropdownList, "Wrong value!");
			}
			
			}
			</zscript>
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val myDropdownList = ztl$engine.$f("myDropdownList")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      var offsetLeft = jq(".z-errorbox").offsetLeft()
      if (isSafari) {
        select(myDropdownList, "zk")
      } else {
        mouseDownAt(myDropdownList, "1,1")
        mouseUpAt(myDropdownList, "1,1")
      }
      //open select tag with IE
      focus(myDropdownList)
      altKeyDown()
      sendKeys(myDropdownList, Keys.DOWN)
      sendKeys(myDropdownList, Keys.DOWN)
      altKeyUp()
      verifyEquals(offsetLeft, jq(".z-errorbox").offsetLeft())
    })
  }
}



