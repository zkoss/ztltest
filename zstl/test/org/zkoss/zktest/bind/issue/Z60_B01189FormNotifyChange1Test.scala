/* Z60_B01189FormNotifyChange1Test.scala

	Purpose:
		
	Description:
		
	History:
		Jul 2, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01189FormNotifyChange1Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01189FormNotifyChange.zul"/>
"""
    runZTL(zul, () => {

      var tb1 = jq("$tb1")
      var tb2 = jq("$tb2")
      var tb3 = jq("$tb3")
      var tb4 = jq("$tb4")

      var save1 = jq("$save1")
      var lb1 = jq("$lb1")

      verifyEquals("", tb1.toWidget().attr("value"))
      verifyEquals("", tb2.toWidget().attr("value"))
      verifyEquals("", tb3.toWidget().attr("value"))
      verifyEquals("", tb4.toWidget().attr("value"))
      verifyEquals("", lb1.toWidget().attr("value"))

      `type`(tb1.toWidget(), "A")
      waitResponse()
      verifyEquals("A", tb2.toWidget().attr("value"))
      verifyEquals("", tb3.toWidget().attr("value"))
      verifyEquals("A", tb4.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("A", lb1.toWidget().attr("value"))

      `type`(tb2.toWidget(), "B")
      waitResponse()
      verifyEquals("B", tb1.toWidget().attr("value"))
      verifyEquals("", tb3.toWidget().attr("value"))
      verifyEquals("B", tb4.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("B", lb1.toWidget().attr("value"))

      `type`(tb3.toWidget(), "C")
      waitResponse()
      verifyEquals("B", tb1.toWidget().attr("value"))
      verifyEquals("B", tb2.toWidget().attr("value"))
      verifyEquals("C", tb4.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("C", lb1.toWidget().attr("value"))

      `type`(tb4.toWidget(), "D")
      waitResponse()
      verifyEquals("B", tb1.toWidget().attr("value"))
      verifyEquals("B", tb2.toWidget().attr("value"))
      verifyEquals("C", tb3.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("D", lb1.toWidget().attr("value"))

      `type`(tb1.toWidget(), "E")
      waitResponse()
      verifyEquals("E", tb2.toWidget().attr("value"))
      verifyEquals("C", tb3.toWidget().attr("value"))
      verifyEquals("E", tb4.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("E", lb1.toWidget().attr("value"))

      `type`(tb2.toWidget(), "F")
      waitResponse()
      verifyEquals("F", tb1.toWidget().attr("value"))
      verifyEquals("C", tb3.toWidget().attr("value"))
      verifyEquals("F", tb4.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("F", lb1.toWidget().attr("value"))

      `type`(tb3.toWidget(), "G")
      waitResponse()
      verifyEquals("F", tb1.toWidget().attr("value"))
      verifyEquals("F", tb2.toWidget().attr("value"))
      verifyEquals("G", tb4.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("G", lb1.toWidget().attr("value"))

      `type`(tb4.toWidget(), "H")
      waitResponse()
      verifyEquals("F", tb1.toWidget().attr("value"))
      verifyEquals("F", tb2.toWidget().attr("value"))
      verifyEquals("G", tb3.toWidget().attr("value"))
      click(save1.toWidget())
      waitResponse()
      verifyEquals("H", lb1.toWidget().attr("value"))

    })
  }
}
