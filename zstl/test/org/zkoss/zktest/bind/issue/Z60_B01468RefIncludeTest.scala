/* Z60_B01468RefIncludeTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Assert

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01468RefIncludeTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01468RefInclude.zul"/>
    }

    runZTL(zul, () => {

      var lb1 = jq("$lb1")
      var lb2 = jq("$lb2")
      var lb3 = jq("$lb3")
      var lb4 = jq("$lb4")
      var lb5 = jq("$lb5")
      var lb6 = jq("$lb6")

      var tb1 = jq("$tb1")

      verifyEquals("ABC", lb1.toWidget().get("value"))
      verifyEquals("ABC", lb2.toWidget().get("value"))
      verifyEquals("ABC", lb3.toWidget().get("value"))
      verifyEquals("ABC", lb4.toWidget().get("value"))
      verifyEquals("ABC", lb5.toWidget().get("value"))
      verifyEquals("ABC", lb6.toWidget().get("value"))

      `type`(tb1.toWidget(), "XYZ")
      waitResponse()

      verifyEquals("XYZ", lb1.toWidget().get("value"))
      verifyEquals("XYZ", lb2.toWidget().get("value"))
      verifyEquals("XYZ", lb3.toWidget().get("value"))
      verifyEquals("XYZ", lb4.toWidget().get("value"))
      verifyEquals("XYZ", lb5.toWidget().get("value"))
      verifyEquals("XYZ", lb6.toWidget().get("value"))
    })
  }
}

