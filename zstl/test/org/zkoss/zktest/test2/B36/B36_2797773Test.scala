/* B36_2797773Test.java

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
import org.zkoss.ztl.unit.Widget


class B36_2797773Test extends ZTL4ScalaTestCase {
  @Test
  def testpaste() = {
    var zscript =
      """
			<zk>
				now support copy paste by ctrl key in intbox
				<intbox value="1234567"/><button id="blur" label="here"/>
			</zk>
		"""
    val ztl$engine = engine()
    val blur = ztl$engine.$f("blur")
    runZTL(zscript, () => {
      focus(jq("@intbox"))
      waitResponse()
      sendKeys(jq("@intbox"), Keys.LEFT_CONTROL + "a")
      waitResponse()
      sendKeys(jq("@intbox"), Keys.LEFT_CONTROL + "x")
      waitResponse()
      clickAt(blur, "6,6");
      waitResponse()
      waitResponse()
      verifyEquals("", getValue(jq("@intbox")))
      focus(jq("@intbox"))
      waitResponse()
      sendKeys(jq("@intbox"), Keys.LEFT_CONTROL + "v")
      waitResponse()
      verifyEquals("1234567", getValue(jq("@intbox")))
    })
  }
}



