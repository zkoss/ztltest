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
import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_LoadSavePropertyTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/basic/load-save-property.zul"/>
"""

    runZTL(zul, () => {
      val t21 = jq("$t21")
      val t22 = jq("$t22")
      val t23 = jq("$t23")
      
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("B", jq("$l12").toWidget().attr("value"))
      verifyEquals("C", jq("$l13").toWidget().attr("value"))
      verifyEquals("A", jq("$l14").toWidget().attr("value"))
      verifyEquals("B", jq("$l15").toWidget().attr("value"))
      verifyEquals("C", jq("$l16").toWidget().attr("value"))
      t21.toElement().set("value", "")
      sendKeys(t21, "X" + Keys.TAB)
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("X", jq("$l12").toWidget().attr("value"))
      verifyEquals("C", jq("$l13").toWidget().attr("value"))
      verifyEquals("X", jq("$l14").toWidget().attr("value"))
      verifyEquals("X", jq("$l15").toWidget().attr("value"))
      verifyEquals("X", jq("$l16").toWidget().attr("value"))
      t22.toElement().set("value", "")
      sendKeys(t22, "Y" + Keys.TAB)
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("X", jq("$l12").toWidget().attr("value"))
      verifyEquals("Y", jq("$l13").toWidget().attr("value"))
      verifyEquals("Y", jq("$l14").toWidget().attr("value"))
      verifyEquals("X", jq("$l15").toWidget().attr("value"))
      verifyEquals("Y", jq("$l16").toWidget().attr("value"))
      t23.toElement().set("value", "")
      sendKeys(t23, "Z" + Keys.TAB)
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("X", jq("$l12").toWidget().attr("value"))
      verifyEquals("Y", jq("$l13").toWidget().attr("value"))
      verifyEquals("Z", jq("$l14").toWidget().attr("value"))
      verifyEquals("X", jq("$l15").toWidget().attr("value"))
      verifyEquals("Y", jq("$l16").toWidget().attr("value"))
      click(jq("$btn1"))
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("Z", jq("$l12").toWidget().attr("value"))
      verifyEquals("Y", jq("$l13").toWidget().attr("value"))
      verifyEquals("Z", jq("$l14").toWidget().attr("value"))
      verifyEquals("Z", jq("$l15").toWidget().attr("value"))
      verifyEquals("Z", jq("$l16").toWidget().attr("value"))
      t23.toElement().set("value", "")
      sendKeys(t23, "G" + Keys.TAB)
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("Z", jq("$l12").toWidget().attr("value"))
      verifyEquals("Y", jq("$l13").toWidget().attr("value"))
      verifyEquals("G", jq("$l14").toWidget().attr("value"))
      verifyEquals("Z", jq("$l15").toWidget().attr("value"))
      verifyEquals("Z", jq("$l16").toWidget().attr("value"))
      click(jq("$btn2"))
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("Z", jq("$l12").toWidget().attr("value"))
      verifyEquals("G", jq("$l13").toWidget().attr("value"))
      verifyEquals("G", jq("$l14").toWidget().attr("value"))
      verifyEquals("Z", jq("$l15").toWidget().attr("value"))
      verifyEquals("G", jq("$l16").toWidget().attr("value"))
      t23.toElement().set("value", "")
      sendKeys(t23, "H" + Keys.TAB)
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("Z", jq("$l12").toWidget().attr("value"))
      verifyEquals("G", jq("$l13").toWidget().attr("value"))
      verifyEquals("H", jq("$l14").toWidget().attr("value"))
      verifyEquals("Z", jq("$l15").toWidget().attr("value"))
      verifyEquals("G", jq("$l16").toWidget().attr("value"))
      click(jq("$btn3"))
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("Z", jq("$l12").toWidget().attr("value"))
      verifyEquals("H", jq("$l13").toWidget().attr("value"))
      verifyEquals("H", jq("$l14").toWidget().attr("value"))
      verifyEquals("Z", jq("$l15").toWidget().attr("value"))
      verifyEquals("H", jq("$l16").toWidget().attr("value"))
    })
  }
}