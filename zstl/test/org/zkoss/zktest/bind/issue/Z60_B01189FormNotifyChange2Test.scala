/* Z60_B01189FormNotifyChange2Test.scala

	Purpose:
		
	Description:
		
	History:
		Jul 3, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01189FormNotifyChange2Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01189FormNotifyChange.zul"/>
"""
    runZTL(zul, () => {

      var tb5 = jq("$tb5")
      var tb6 = jq("$tb6")
      var tb7 = jq("$tb7")
      var tb8 = jq("$tb8")

      var save2 = jq("$save2")
      var lb2 = jq("$lb2")
      var lb3 = jq("$lb3")

      verifyEquals("", tb5.toWidget().attr("value"))
      verifyEquals("", tb6.toWidget().attr("value"))
      verifyEquals("", tb7.toWidget().attr("value"))
      verifyEquals("", tb8.toWidget().attr("value"))
      verifyEquals("", lb2.toWidget().attr("value"))
      verifyEquals("", lb3.toWidget().attr("value"))

      `type`(tb5.toWidget(), "A")
      waitResponse()
      verifyEquals("A", tb6.toWidget().attr("value"))
      verifyEquals("", tb7.toWidget().attr("value"))
      verifyEquals("", tb8.toWidget().attr("value"))

      `type`(tb6.toWidget(), "B")
      waitResponse()
      verifyEquals("B", tb5.toWidget().attr("value"))
      verifyEquals("", tb7.toWidget().attr("value"))
      verifyEquals("", tb8.toWidget().attr("value"))

      `type`(tb7.toWidget(), "C")
      waitResponse()
      verifyEquals("B", tb5.toWidget().attr("value"))
      verifyEquals("B", tb6.toWidget().attr("value"))
      verifyEquals("C", tb8.toWidget().attr("value"))

      `type`(tb8.toWidget(), "D")
      waitResponse()
      verifyEquals("B", tb5.toWidget().attr("value"))
      verifyEquals("B", tb6.toWidget().attr("value"))
      verifyEquals("D", tb7.toWidget().attr("value"))

      click(save2.toWidget())
      waitResponse()
      verifyEquals("B", lb2.toWidget().attr("value"))
      verifyEquals("D", lb3.toWidget().attr("value"))

    })
  }
}
