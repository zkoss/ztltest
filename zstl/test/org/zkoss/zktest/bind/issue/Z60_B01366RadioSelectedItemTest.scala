/* Z60_B01366RadioSelectedItemTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 7, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01366RadioSelectedItemTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01366RadioSelectedItem.zul"/>
"""
    runZTL(zul, () => {

      var rg1 = jq("$radiogroup1")
      var rg2 = jq("$radiogroup2")
      var lb1 = jq("$lb1")

      click(rg1.find("@radio").eq(0).toWidget().$n("real"))
      waitResponse()
      verifyEquals("true", rg2.find("@radio").eq(0).toWidget().get("checked"))
      verifyEquals("false", rg2.find("@radio").eq(1).toWidget().get("checked"))
      verifyEquals("false", rg2.find("@radio").eq(2).toWidget().get("checked"))
      verifyEquals("name 0", lb1.toWidget().get("value"))

      click(rg2.find("@radio").eq(1).toWidget().$n("real"))
      waitResponse()
      verifyEquals("false", rg1.find("@radio").eq(0).toWidget().get("checked"))
      verifyEquals("true", rg1.find("@radio").eq(1).toWidget().get("checked"))
      verifyEquals("false", rg1.find("@radio").eq(2).toWidget().get("checked"))
      verifyEquals("name 1", lb1.toWidget().get("value"))

    })
  }
}
