/* Z60_F01048FormBindingMessageTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F01048FormBindingMessageTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F01048FormBindingMessage.zul"/>
"""

    runZTL(zul, () => {

      var tb1 = jq("$tb1")
      var tb2 = jq("$tb2")
      var tb3 = jq("$tb3")

      var lb1 = jq("$lb1")
      var lb2 = jq("$lb2")
      var lb3 = jq("$lb3")

      var save = jq("$save")

      click(save.toWidget())
      waitResponse()
      verifyEquals("First name is missing.", lb1.toWidget().get("value"))
      verifyEquals("Last name is missing.", lb2.toWidget().get("value"))
      verifyEquals("Age is missing.", lb3.toWidget().get("value"))

      `type`(tb1.toWidget(), "Dennis")
      waitResponse()
      verifyEquals("", lb1.toWidget().get("value"))

      `type`(tb2.toWidget(), "Chen")
      waitResponse()
      verifyEquals("", lb2.toWidget().get("value"))

      `type`(tb3.toWidget(), "35")
      waitResponse()
      verifyEquals("", lb3.toWidget().get("value"))

      `type`(tb1.toWidget(), "")
      waitResponse()
      `type`(tb3.toWidget(), "")
      waitResponse()

      verifyEquals("", lb1.toWidget().get("value"))
      verifyEquals("", lb2.toWidget().get("value"))
      verifyEquals("", lb3.toWidget().get("value"))

      click(save.toWidget())
      waitResponse()

      verifyEquals("First name is missing.", lb1.toWidget().get("value"))
      verifyEquals("", lb2.toWidget().get("value"))
      verifyEquals("Age is missing.", lb3.toWidget().get("value"))

      `type`(tb1.toWidget(), "DennisA")
      waitResponse()
      verifyEquals("", lb1.toWidget().get("value"))

      `type`(tb2.toWidget(), "ChenB")
      waitResponse()
      verifyEquals("", lb2.toWidget().get("value"))

      `type`(tb3.toWidget(), "37")
      waitResponse()
      verifyEquals("", lb3.toWidget().get("value"))

      click(save.toWidget())
      waitResponse()
      verifyEquals("", lb1.toWidget().get("value"))
      verifyEquals("", lb2.toWidget().get("value"))
      verifyEquals("", lb3.toWidget().get("value"))
      verifyEquals("Update DennisA,ChenB,37", jq("$msg").toWidget().get("value"))

    })
  }
}
