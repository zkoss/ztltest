
/* Z60_B01165InnerViewMdelTest.scala

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
class Z60_B01165InnerViewMdelTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01165NestedBinder.zul"/>
"""
    runZTL(zul, () => {

      var outerPidLb = jq("$outerPidLb")
      var outerPDescLb = jq("$outerPDescLb")
      var pidLb = jq("$pidLb")
      var pDescLb = jq("$pDescLb")
      var vmsSelIdLb = jq("$vmsSelIdLb")
      var vmsSelDescLb = jq("$vmsSelDescLb")

      verifyEquals("b3", outerPidLb.toWidget().get("value"))
      verifyEquals("this is b3", outerPDescLb.toWidget().get("value"))
      verifyEquals("b3", pidLb.toWidget().get("value"))
      verifyEquals("this is b3", pDescLb.toWidget().get("value"))
      verifyEquals("b3", vmsSelIdLb.toWidget().get("value"))
      verifyEquals("this is b3", vmsSelDescLb.toWidget().get("value"))

    })
  }
}
