/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00913ValueReloadTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00913ValueReload.zul"/>
    }

    runZTL(zul, () => {

      var tb1 = jq("$tb1")
      var l1 = jq("$l1")
      var msg1 = jq("$msg1")

      verifyEquals("", msg1.toWidget().get("value"))

      `type`(tb1.toWidget(), "abc")
      waitResponse()

      verifyEquals("value has to be def", msg1.toWidget().get("value"))
      verifyEquals("abc", tb1.toWidget().get("value"))
      verifyEquals("KGB", l1.toWidget().get("value"))

      `type`(tb1.toWidget(), "def")
      waitResponse()

      verifyEquals("", msg1.toWidget().get("value"))
      verifyEquals("def", tb1.toWidget().get("value"))
      verifyEquals("def", l1.toWidget().get("value"))

    })
  }
}

