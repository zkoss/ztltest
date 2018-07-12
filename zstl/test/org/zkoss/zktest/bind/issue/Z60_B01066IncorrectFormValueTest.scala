

/* Z60_B01066IncorrectFormValueTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 24, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01066IncorrectFormValueTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01066IncorrectFormValue.zul"/>
"""

    runZTL(zul, () => {

      var tb1 = jq("$tb1")
      var save = jq("$save")

      var lb1 = jq("$lb1")
      var lb2 = jq("$lb2")

      verifyEquals("A", lb1.toWidget().attr("value"))
      verifyEquals("A", lb2.toWidget().attr("value"))

      `type`(tb1.toWidget(), "Abc")
      waitResponse()

      verifyEquals("A", lb1.toWidget().attr("value"))
      verifyEquals("A", lb2.toWidget().attr("value"))

      click(save.toWidget())
      waitResponse()

      verifyEquals("Abc", lb1.toWidget().attr("value"))
      verifyEquals("Abc", lb2.toWidget().attr("value"))

    })
  }
}

