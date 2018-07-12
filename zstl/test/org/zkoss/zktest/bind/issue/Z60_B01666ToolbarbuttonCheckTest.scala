/* Z60_B01666ToolbarbuttonCheckTest.scala

	Purpose:
		
	Description:
		
	History:
		May 2, 2013 Created by Pao Wang

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01666ToolbarbuttonCheckTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01666ToolbarbuttonCheck.zul"/>
"""

    runZTL(zul, () => {

      var checkedLab = jq("$checkedLab")
      var messageLab = jq("$messageLab")
      var btn1 = jq("$btn1")

      click(btn1.toWidget())
      waitResponse()
      verifyEquals("false", checkedLab.toWidget().attr("value"))
      verifyEquals("checked false", messageLab.toWidget().attr("value"))

      click(btn1.toWidget())
      waitResponse()
      verifyEquals("true", checkedLab.toWidget().attr("value"))
      verifyEquals("checked true", messageLab.toWidget().attr("value"))

    })
  }
}