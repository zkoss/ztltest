/* Z60_B01299RefNPETest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 6, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01299RefNPETest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01299RefNPE.zul"/>
"""
    runZTL(zul, () => {

      `type`(jq("$tba1").toWidget(), "AA")
      waitResponse()
      verifyEquals("AA", jq("$lba1").toWidget().get("value"))

      `type`(jq("$tba2").toWidget(), "BB")
      waitResponse()
      verifyEquals("BB", jq("$lba2").toWidget().get("value"))

      `type`(jq("$tba3").toWidget(), "CC")
      waitResponse()
      verifyEquals("CC", jq("$lba31").toWidget().get("value"))
      verifyEquals("CC", jq("$lba32").toWidget().get("value"))
      verifyEquals("CC", jq("$lba33").toWidget().get("value"))
      verifyEquals("CC", jq("$lba34").toWidget().get("value"))

      // condition

      `type`(jq("$tbb1").toWidget(), "D")
      waitResponse()
      click(jq("$btnb1").toWidget())
      waitResponse()
      verifyEquals("D", jq("$lbb1").toWidget().get("value"))

      `type`(jq("$tbb2").toWidget(), "E")
      waitResponse()
      click(jq("$btnb2").toWidget())
      waitResponse()
      verifyEquals("E", jq("$lbb2").toWidget().get("value"))

      `type`(jq("$tbb3").toWidget(), "F")
      waitResponse()
      click(jq("$btnb3").toWidget())
      waitResponse()
      verifyEquals("F", jq("$lbb3").toWidget().get("value"))

      `type`(jq("$tbb4").toWidget(), "G")
      waitResponse()
      click(jq("$btnb4").toWidget())
      waitResponse()
      verifyEquals("G", jq("$lbb41").toWidget().get("value"))
      verifyEquals("G", jq("$lbb42").toWidget().get("value"))
      verifyEquals("G", jq("$lbb43").toWidget().get("value"))
      verifyEquals("G", jq("$lbb44").toWidget().get("value"))

      `type`(jq("$tbb5").toWidget(), "H")
      waitResponse()
      click(jq("$btnb5").toWidget())
      waitResponse()
      verifyEquals("H", jq("$lbb5").toWidget().get("value"))

      `type`(jq("$tbb6").toWidget(), "I")
      waitResponse()
      click(jq("$btnb6").toWidget())
      waitResponse()
      verifyEquals("I", jq("$lbb61").toWidget().get("value"))
      verifyEquals("I", jq("$lbb62").toWidget().get("value"))
      verifyEquals("I", jq("$lbb63").toWidget().get("value"))
      verifyEquals("I", jq("$lbb64").toWidget().get("value"))

    })
  }
}
