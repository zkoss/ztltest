/* Z60_B01005BeanValidatorPathTest.scala

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
class Z60_B01005BeanValidatorPathTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01005BeanValidatorPath.zul"/>
"""

    runZTL(zul, () => {

    	var t1 = jq("$t1")
		var t2 = jq("$t2")
		var l1 = jq("$l1")
		
		var msg1 = jq("$msg1")
		var msg2 = jq("$msg2")
		
		var update = jq("$update")
		var msg = jq("$msg")
		
		verifyEquals("A", t1.toWidget().get("value"))
		`type`(t1.toWidget(), "Aa")
		waitResponse()
		verifyEquals("min length is 3", msg1.toWidget().get("value"))
		verifyEquals("A", l1.toWidget().get("value"))

		`type`(t1.toWidget(),"Aab")
		waitResponse()
		verifyEquals("", msg1.toWidget().get("value"))
		verifyEquals("Aab", l1.toWidget().get("value"))
		
		
		verifyEquals("A", t2.toWidget().get("value"))
		`type`(t2.toWidget() , "Ab")
		waitResponse()
		verifyEquals("min length is 3", msg2.toWidget().get("value"))
		verifyEquals("Aab", l1.toWidget().get("value"))

		`type`(t2.toWidget(),"Abc")
		waitResponse()
		verifyEquals("", msg2.toWidget().get("value"))
		verifyEquals("Aab", l1.toWidget().get("value"))
		
		click(update.toWidget())
		waitResponse()
		verifyEquals("Abc", t1.toWidget().get("value"))
		verifyEquals("Abc", l1.toWidget().get("value"))
		
		verifyEquals("update value1:Abc", msg.toWidget().get("value"))
	
    })
  }
}
