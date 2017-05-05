/* Z60_B01640CommandSend2WrongViewModelTest.scala

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
class Z60_B01640CommandSend2WrongViewModelTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01640CommandSend2WrongViewModel.zul"/>
"""

    runZTL(zul, () => {

      var showChildBtn = jq("$showChildBtn")
      click(showChildBtn.toWidget())
      waitResponse()

      var lab = jq("$lab")

      verifyEquals("initialized", lab.toWidget().get("value"))

      var outerBtn = jq("$outerBtn")
      click(outerBtn.toWidget())
      waitResponse()
      verifyEquals("do outerGridCommand", lab.toWidget().get("value"))

      var innerBtn = jq("$innerBtn")
      click(innerBtn.toWidget())
      waitResponse()
      verifyEquals("do innerGridCommand A", lab.toWidget().get("value"))

    })
  }
}

