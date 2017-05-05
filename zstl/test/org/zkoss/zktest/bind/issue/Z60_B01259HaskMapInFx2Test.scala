/* Z60_B01259HaskMapInFx2Test.scala

	Purpose:
		
	Description:
		
	History:
		Nov 7, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Assert

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01259HaskMapInFx2Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01259HaskMapInFx2.zul"/>
"""
    runZTL(zul, () => {

      var l11 = jq("$l11")
      var l12 = jq("$l12")
      var l13 = jq("$l13")
      var l14 = jq("$l14")
      var l15 = jq("$l15")

      verifyEquals("Hello World", l11.toWidget().get("value"))
      verifyEquals("Hello World", l12.toWidget().get("value"))
      verifyEquals("Hello World", l13.toWidget().get("value"))
      verifyEquals("Hi Dennis", l14.toWidget().get("value"))
      verifyEquals("Hi Dennis", l15.toWidget().get("value"))

    })
  }
}
