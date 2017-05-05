/* Z60_B01469ScopeParamRefTest.scala

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
class Z60_B01469ScopeParamRefTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01469ScopeParamRef.zul"/>
"""
    
    runZTL(zul, () => {
      var l1 = jq("$l1")
      var l2 = jq("$l2")
      var l3 = jq("$l3")

      verifyEquals("ABC", l1.toWidget().get("value"))
      verifyEquals("ABC", l2.toWidget().get("value"))
      verifyEquals("ABC", l3.toWidget().get("value"))
    })
  }
}