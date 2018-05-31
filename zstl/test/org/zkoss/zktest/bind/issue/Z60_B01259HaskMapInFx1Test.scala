/* Z60_B01259HaskMapInFx1Test.scala

	Purpose:
		
	Description:
		
	History:
		Nov 7, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01259HaskMapInFx1Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01259HaskMapInFx1.zul"/>
"""
    runZTL(zul, () => {

      var l11 = jq("$l11")
      var l12 = jq("$l12")
      var l13 = jq("$l13")
      var l14 = jq("$l14")
      var l15 = jq("$l15")

      var t21 = jq("$t21")
      var t22 = jq("$t22")
      var btn2 = jq("$btn2")

      var t31 = jq("$t31")
      var t32 = jq("$t32")
      var btn3 = jq("$btn3")

      verifyEquals("Hello World", l11.toWidget().get("value"))
      verifyEquals("Hello World", l12.toWidget().get("value"))
      verifyEquals("Hello World", l13.toWidget().get("value"))
      verifyEquals("Hi Dennis", l14.toWidget().get("value"))
      verifyEquals("Hi Dennis", l15.toWidget().get("value"))

      `type`(t21.toWidget(), "AAA")
      waitResponse()
      `type`(t22.toWidget(), "BBB")
      waitResponse()
      verifyEquals("Hello World", l11.toWidget().get("value"))
      verifyEquals("Hello World", l12.toWidget().get("value"))
      verifyEquals("Hello World", l13.toWidget().get("value"))
      verifyEquals("Hi Dennis", l14.toWidget().get("value"))
      verifyEquals("Hi Dennis", l15.toWidget().get("value"))

      click(btn2.toWidget())
      waitResponse()
      verifyEquals("AAA", l11.toWidget().get("value"))
      verifyEquals("AAA", l12.toWidget().get("value"))
      verifyEquals("AAA", l13.toWidget().get("value"))
      verifyEquals("BBB", l14.toWidget().get("value"))
      verifyEquals("BBB", l15.toWidget().get("value"))

      `type`(t31.toWidget(), "CCC")
      waitResponse()
      `type`(t32.toWidget(), "DDD")
      waitResponse()

      verifyEquals("AAA", l11.toWidget().get("value"))
      verifyEquals("CCC", l12.toWidget().get("value"))
      verifyEquals("AAA", l13.toWidget().get("value"))
      verifyEquals("BBB", l14.toWidget().get("value"))
      verifyEquals("DDD", l15.toWidget().get("value"))

      click(btn3.toWidget())
      waitResponse()
      verifyEquals("CCC", l11.toWidget().get("value"))
      verifyEquals("CCC", l12.toWidget().get("value"))
      verifyEquals("CCC", l13.toWidget().get("value"))
      verifyEquals("DDD", l14.toWidget().get("value"))
      verifyEquals("DDD", l15.toWidget().get("value"))

    })
  }
}
