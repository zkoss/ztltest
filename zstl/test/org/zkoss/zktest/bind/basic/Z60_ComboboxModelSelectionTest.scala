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
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ComboboxModelSelectionTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/comboboxmodelselection.zul"/>
"""

    runZTL(zul, () => {
      var combobox1 = jq("$cb1")
      var combobox2 = jq("$cb2")
      verifyEquals("", jq("$msg").toWidget().attr("value"))
      evalScript(combobox1.toWidget() + ".open()") // has to wait for open
      waitResponse()
      var items = combobox1.find("@comboitem")
      evalScript(combobox1.toWidget() + ".open()") // has to wait for open
      waitResponse()
      click(items.eq(1).toWidget())
      waitResponse()
      verifyEquals("B", combobox1.toWidget().attr("value"))
      verifyEquals("A", combobox2.toWidget().attr("value"))
      evalScript(combobox1.toWidget() + ".open()") // has to wait for open
      waitResponse()
      click(items.eq(2).toWidget())
      waitResponse()
      verifyEquals("C", combobox1.toWidget().attr("value"))
      verifyEquals("A", combobox2.toWidget().attr("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("reloaded", jq("$msg").toWidget().attr("value"))
      verifyEquals("C", combobox1.toWidget().attr("value"))
      verifyEquals("A", combobox2.toWidget().attr("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("selected", jq("$msg").toWidget().attr("value"))
      verifyEquals("C", combobox1.toWidget().attr("value"))
      verifyEquals("D", combobox2.toWidget().attr("value"))
    })
  }
}