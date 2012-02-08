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
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_FunctionTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/basic/function.zul"/>
    }

    runZTL(zul, () => {
      verifyEquals("foo", jq("$l11").toWidget().get("value"))
      verifyEquals("foo", jq("$l12").toWidget().get("value"))
      verifyEquals("foo:2bar", jq("$l13").toWidget().get("value"))
      verifyEquals("foo:foo:b", jq("$l14").toWidget().get("value"))
      click(jq("$cmd1").toWidget())
      waitResponse()
      verifyEquals("foo0", jq("$l11").toWidget().get("value"))
      verifyEquals("foo0", jq("$l12").toWidget().get("value"))
      verifyEquals("foo:2bar", jq("$l13").toWidget().get("value"))
      verifyEquals("foo0:foo0:b", jq("$l14").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("foo1", jq("$l11").toWidget().get("value"))
      verifyEquals("foo1", jq("$l12").toWidget().get("value"))
      verifyEquals("foo1:2bar", jq("$l13").toWidget().get("value"))
      verifyEquals("foo1:foo1:b", jq("$l14").toWidget().get("value"))
      click(jq("$cmd3").toWidget())
      waitResponse()
      verifyEquals("foo1", jq("$l11").toWidget().get("value"))
      verifyEquals("foo1", jq("$l12").toWidget().get("value"))
      verifyEquals("foo1:2bar", jq("$l13").toWidget().get("value"))
      verifyEquals("foo2:foo2:b", jq("$l14").toWidget().get("value"))
    })
  }
}
