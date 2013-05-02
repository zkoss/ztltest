/* Z60_B01615ChildrenBindingInFormTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01615ChildrenBindingInFormTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01615ChildrenBindingInForm.zul"/>
    }

    runZTL(zul, () => {

      var labs1 = jq("$w1 @label")
      var labs2 = jq("$w2 @label")
      var labs3 = jq("$w3 @label")

      verifyEquals(3, labs1.length())
      verifyEquals(3, labs2.length())
      verifyEquals(3, labs3.length())

      verifyEquals("A", labs1.eq(0).toWidget().get("value"))
      verifyEquals("B", labs1.eq(1).toWidget().get("value"))
      verifyEquals("C", labs1.eq(2).toWidget().get("value"))

      verifyEquals("D", labs2.eq(0).toWidget().get("value"))
      verifyEquals("E", labs2.eq(1).toWidget().get("value"))
      verifyEquals("F", labs2.eq(2).toWidget().get("value"))

      verifyEquals("X", labs3.eq(0).toWidget().get("value"))
      verifyEquals("Y", labs3.eq(1).toWidget().get("value"))
      verifyEquals("Z", labs3.eq(2).toWidget().get("value"))

    })
  }
}
