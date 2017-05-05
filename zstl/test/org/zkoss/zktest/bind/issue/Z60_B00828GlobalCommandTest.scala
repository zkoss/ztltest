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
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00828GlobalCommandTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00828GlobalCommand.zul"/>
"""

    runZTL(zul, () => {

      var post = jq("$post").toWidget()
      for (i <- 0 to 4) {
        click(post)
        waitResponse()
        var w = jq(".z-window-modal").toWidget()
        verifyFalse(w.exists())
      }

    })
  }
}


