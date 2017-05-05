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
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_SelectboxModelSelectionTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/selectboxmodelselection.zul"/>
"""

    runZTL(zul, () => {
      var sb1 = engine.$f("sb1")
      var sb2 = engine.$f("sb2")
      var sb3 = engine.$f("sb3")
      var msg = engine.$f("msg")
      var btn1 = engine.$f("btn1")
      var btn2 = engine.$f("btn2")
      verifyEquals("", msg.get("value"))
      verifyEquals("-1", sb1.get("selectedIndex"))
      verifyEquals("-1", sb2.get("selectedIndex"))
      verifyEquals("1", sb3.get("selectedIndex"))
      select(jq(sb1), 0)
      waitResponse()
      select(jq(sb2), 1)
      waitResponse()
      select(jq(sb3), 2)
      waitResponse()
      verifyEquals("0", sb1.get("selectedIndex"))
      verifyEquals("1", sb2.get("selectedIndex"))
      verifyEquals("2", sb3.get("selectedIndex"))
      click(btn1)
      waitResponse()
      verifyEquals("0", sb1.get("selectedIndex"))
      verifyEquals("1", sb2.get("selectedIndex"))
      verifyEquals("2", sb3.get("selectedIndex"))
      click(btn2)
      waitResponse()
      verifyEquals("0", sb1.get("selectedIndex"))
      verifyEquals("1", sb2.get("selectedIndex"))
      verifyEquals("3", sb3.get("selectedIndex"))
    })
  }
}
