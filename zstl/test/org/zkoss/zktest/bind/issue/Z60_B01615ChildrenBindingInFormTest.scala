/* Z60_B01615ChildrenBindingInFormTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01615ChildrenBindingInFormTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01615ChildrenBindingInForm.zul"/>
"""

    runZTL(zul, () => {

      var labs1 = jq("$w1").find("@label")
      var labs2 = jq("$w2").find("@label")
      var labs3 = jq("$w3").find("@label")

      verifyEquals(3, labs1.length())
      verifyEquals(3, labs2.length())
      verifyEquals(3, labs3.length())

      verifyEquals("A", getText(labs1.eq(0)))
      verifyEquals("B", getText(labs1.eq(1)))
      verifyEquals("C", getText(labs1.eq(2)))

      verifyEquals("D", getText(labs2.eq(0)))
      verifyEquals("E", getText(labs2.eq(1)))
      verifyEquals("F", getText(labs2.eq(2)))

      verifyEquals("X", getText(labs3.eq(0)))
      verifyEquals("Y", getText(labs3.eq(1)))
      verifyEquals("Z", getText(labs3.eq(2)))

    })
  }
}
