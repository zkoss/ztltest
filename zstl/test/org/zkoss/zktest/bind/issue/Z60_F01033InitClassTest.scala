/* Z60_F01033InitClassTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 24, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F01033InitClassTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F01033InitClass.zul"/>
"""

    runZTL(zul, () => {

      var l11 = jq("$l11")
      var l12 = jq("$l12")
      var l21 = jq("$l21")
      var l22 = jq("$l22")

      verifyEquals("", l11.toWidget().attr("value"))
      verifyEquals("Chen", l12.toWidget().attr("value"))
      verifyEquals("Ian", l21.toWidget().attr("value"))
      verifyEquals("Tasi", l22.toWidget().attr("value"))

    })
  }
}

