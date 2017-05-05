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
class Z60_ScopeParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/scopeparam.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("requestScope-A", jq("$l15").toWidget().get("value"))
      verifyEquals("B", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("", jq("$l19").toWidget().get("value"))
      click(jq("$cmd1").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("var2 by Desktop", jq("$l11").toWidget().get("value"))
      verifyEquals("var1 by Desktop", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
      click(jq("$cmd3").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("var2 by Desktop", jq("$l11").toWidget().get("value"))
      verifyEquals("var1 by Desktop", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
    })
  }
}