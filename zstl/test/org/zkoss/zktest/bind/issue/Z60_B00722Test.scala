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
import org.junit.Test
import org.openqa.selenium.Keys

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00722Test extends ZTL4ScalaTestCase {
  @Test
  def testIssue() = {
    val zul = {
      <include src="/bind/issue/B00722.zul"/>
    }

    runZTL(zul, () => {
      var l11 = jq("$l11")
      var t21 = jq("$t21")
      var m21 = jq("$m21")
      var cmd1 = jq("$cmd1")
      var cmd2 = jq("$cmd2")
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("abc", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
      t21.toElement().set("value", "")
      sendKeys(t21.toWidget(), "efg" + Keys.TAB)
      waitResponse()
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("efg", t21.toWidget().get("value"))
      verifyEquals("the value has to be 'abc' or 'ABC'", m21.toWidget().get("value"))
      click(cmd1.toWidget())
      waitResponse()
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("efg", t21.toWidget().get("value"))
      verifyEquals("the value has to be 'abc' or 'ABC'", m21.toWidget().get("value"))
      t21.toElement().set("value", "")
      sendKeys(t21.toWidget(), "ABC" + Keys.TAB)
      waitResponse()
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("ABC", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
      click(cmd1.toWidget())
      waitResponse()
      verifyEquals("ABC:saved", l11.toWidget().get("value"))
      verifyEquals("ABC", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
      t21.toElement().set("value", "")
      sendKeys(t21.toWidget(), "kkk" + Keys.TAB)
      waitResponse()
      verifyEquals("ABC:saved", l11.toWidget().get("value"))
      verifyEquals("kkk", t21.toWidget().get("value"))
      verifyEquals("the value has to be 'abc' or 'ABC'", m21.toWidget().get("value"))
      click(cmd2.toWidget())
      waitResponse()
      verifyEquals("ABC:saved", l11.toWidget().get("value"))
      verifyEquals("ABC:saved", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
    })
  }
}