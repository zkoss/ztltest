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
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00772InterCommTest extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F00772-inter-comm.zul"/>
"""

    runZTL(zul, () => {

      var t11 = jq("$t11")
      var l21 = jq("$l21")
      var l31 = jq("$l31")
      var l41 = jq("$l41")
      var postx = jq("$postx")
      var posty = jq("$posty")
      var postz = jq("$postz")
      var postmy = jq("$postmy")
      var globalx = jq("$globalx")
      var globaly = jq("$globaly")
      var globalz = jq("$globalz")
      verifyEquals("", t11.toWidget().get("value"))
      verifyEquals("", l21.toWidget().get("value"))
      verifyEquals("", l31.toWidget().get("value"))
      verifyEquals("", l41.toWidget().get("value"))
      click(postx.toWidget())
      waitResponse()
      verifyEquals("postX-X1", l21.toWidget().get("value"))
      verifyEquals("postX-X2", l31.toWidget().get("value"))
      verifyEquals("", l41.toWidget().get("value"))
      click(posty.toWidget())
      waitResponse()
      verifyEquals("postX-X1", l21.toWidget().get("value"))
      verifyEquals("postY-X2", l31.toWidget().get("value"))
      verifyEquals("", l41.toWidget().get("value"))
      click(postz.toWidget())
      waitResponse()
      verifyEquals("postE-X1", l21.toWidget().get("value"))
      verifyEquals("postZ-X3", l31.toWidget().get("value"))
      verifyEquals("", l41.toWidget().get("value"))
      click(postmy.toWidget())
      waitResponse()
      verifyEquals("postE-X1", l21.toWidget().get("value"))
      verifyEquals("postZ-X3", l31.toWidget().get("value"))
      verifyEquals("postMy-XMy", l41.toWidget().get("value"))
      `type`(t11.toWidget(), "A")
      waitResponse()
      click(globalx.toWidget())
      waitResponse()
      verifyEquals("A-local-X1", l21.toWidget().get("value"))
      verifyEquals("A-local-X2", l31.toWidget().get("value"))
      verifyEquals("postMy-XMy", l41.toWidget().get("value"))
      click(globaly.toWidget())
      waitResponse()
      verifyEquals("A-local-X1", l21.toWidget().get("value"))
      verifyEquals("A-local-X1-X2", l31.toWidget().get("value"))
      verifyEquals("postMy-XMy", l41.toWidget().get("value"))
      click(globalz.toWidget())
      waitResponse()
      verifyEquals("postE-X1", l21.toWidget().get("value"))
      verifyEquals("A-local-X1-X2-X3", l31.toWidget().get("value"))
      verifyEquals("postMy-XMy", l41.toWidget().get("value"))

    })
  }
}

