/* Z60_B01887DetachAttachTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 29, 2013 Created by Kuro Chung

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author kuro
 */
@Tags(tags = "zbind")
class Z60_B01887DetachAttachTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01887DetachAttach.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("/bind/issue/B01887DetachAttachInner1.zul", jq("$lab1").toWidget().get("value"));
      verifyEquals(null, jq("$lab2").toWidget())
      
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("/bind/issue/B01887DetachAttachInner2.zul", jq("$lab2").toWidget().get("value"));
      verifyEquals(null, jq("$lab1").toWidget())
      
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("/bind/issue/B01887DetachAttachInner1.zul", jq("$lab1").toWidget().get("value"));
      verifyEquals(null, jq("$lab2").toWidget())
    })

  }
}