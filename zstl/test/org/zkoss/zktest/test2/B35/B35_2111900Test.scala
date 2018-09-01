/* B35_2111900Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2111900Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="The onChanging event" border="normal">
	Please type some words in the textbox, then the instant-copy should work well.
	<grid width="80%">
	<rows>
		<row>onChanging textbox: <textbox multiline="true" rows="2"  onChanging="copy.value = event.value"/></row>
		<row>instant copy: <textbox id="copy" readonly="true"/></row>
	</rows>
	</grid>
</window>

		"""
    val ztl$engine = engine()
    val copy = ztl$engine.$f("copy")
    runZTL(zscript, () => {
      var testWord = "i am tester~happy~tester~~"
      typeKeys(jq("@textbox"), testWord)
      waitResponse()
      verifyEquals(testWord, copy.attr("value"))
    })
  }
}



