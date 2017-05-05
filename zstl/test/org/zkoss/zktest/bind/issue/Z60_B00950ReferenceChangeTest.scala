
/* Z60_B00950ReferenceChangeTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 20, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00950ReferenceChangeTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00950ReferenceChange.zul"/>
"""

    runZTL(zul, () => {

      var listbox = jq("$listbox")
      var l11 = jq("$l11")
      var l12 = jq("$l12")
      var l13 = jq("$l13")
      var l21 = jq("$l21")
      var l22 = jq("$l22")
      var l23 = jq("$l23")
      var clear = jq("$clear")

      verifyEquals("", l11.toWidget().get("value"))
      verifyEquals("", l12.toWidget().get("value"))
      verifyEquals("", l13.toWidget().get("value"))
      verifyEquals("", l21.toWidget().get("value"))
      verifyEquals("", l22.toWidget().get("value"))
      verifyEquals("", l23.toWidget().get("value"))

      click(listbox.find("@listitem").eq(0).toWidget())
      waitResponse()
      verifyEquals("Dennis", l11.toWidget().get("value"))
      verifyEquals("Chen", l12.toWidget().get("value"))
      verifyEquals("Dennis Chen", l13.toWidget().get("value"))
      verifyEquals("Dennis", l21.toWidget().get("value"))
      verifyEquals("Chen", l22.toWidget().get("value"))
      verifyEquals("Dennis Chen", l23.toWidget().get("value"))

      click(listbox.find("@listitem").eq(1).toWidget())
      waitResponse()
      verifyEquals("Alice", l11.toWidget().get("value"))
      verifyEquals("Lin", l12.toWidget().get("value"))
      verifyEquals("Alice Lin", l13.toWidget().get("value"))
      verifyEquals("Alice", l21.toWidget().get("value"))
      verifyEquals("Lin", l22.toWidget().get("value"))
      verifyEquals("Alice Lin", l23.toWidget().get("value"))

      click(listbox.find("@listitem").eq(2).toWidget())
      waitResponse()
      verifyEquals("", l11.toWidget().get("value"))
      verifyEquals("", l12.toWidget().get("value"))
      verifyEquals("", l13.toWidget().get("value"))
      verifyEquals("", l21.toWidget().get("value"))
      verifyEquals("", l22.toWidget().get("value"))
      verifyEquals("", l23.toWidget().get("value"))

      click(listbox.find("@listitem").eq(1).toWidget())
      waitResponse()
      `type`(listbox.find("@listitem").eq(1).find("@textbox").toWidget(), "Grace")
      waitResponse()
      verifyEquals("Grace", l11.toWidget().get("value"))
      verifyEquals("Lin", l12.toWidget().get("value"))
      verifyEquals("Grace Lin", l13.toWidget().get("value"))
      verifyEquals("Grace", l21.toWidget().get("value"))
      verifyEquals("Lin", l22.toWidget().get("value"))
      verifyEquals("Grace Lin", l23.toWidget().get("value"))

      click(clear.toWidget())
      waitResponse()
      verifyEquals("", l11.toWidget().get("value"))
      verifyEquals("", l12.toWidget().get("value"))
      verifyEquals("", l13.toWidget().get("value"))
      verifyEquals("", l21.toWidget().get("value"))
      verifyEquals("", l22.toWidget().get("value"))
      verifyEquals("", l23.toWidget().get("value"))

    })
  }
}


