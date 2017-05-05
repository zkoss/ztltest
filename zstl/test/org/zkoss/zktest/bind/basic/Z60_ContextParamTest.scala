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
class Z60_ContextParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/contextparam.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("requestScope-A", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-B", jq("$l16").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("true", jq("$l19").toWidget().get("value"))
      verifyEquals("true", jq("$l1a").toWidget().get("value"))
      click(jq("$cmd1").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-C", jq("$l16").toWidget().get("value"))
      verifyEquals("cmd1", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("false", jq("$l19").toWidget().get("value"))
      verifyEquals("false", jq("$l1a").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("var2 by Desktop", jq("$l11").toWidget().get("value"))
      verifyEquals("var1 by Desktop", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-Y", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-C", jq("$l16").toWidget().get("value"))
      verifyEquals("cmd2", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("false", jq("$l19").toWidget().get("value"))
      verifyEquals("false", jq("$l1a").toWidget().get("value"))
      click(jq("$cmd3").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-Y", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-C", jq("$l16").toWidget().get("value"))
      verifyEquals("cmd3", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("false", jq("$l19").toWidget().get("value"))
      verifyEquals("false", jq("$l1a").toWidget().get("value"))
    })
  }
}