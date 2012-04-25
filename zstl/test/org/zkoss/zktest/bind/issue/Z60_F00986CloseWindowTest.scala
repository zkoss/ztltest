/* Z60_F00986CloseWindowTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 24, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00986CloseWindowTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/F00986CloseWindow.zul"/>
    }

    runZTL(zul, () => {

      var detach = jq("$detach")

      verifyTrue(jq("$win1").exists())
      verifyTrue(jq("$win2").exists())
      verifyTrue(jq("$win3").exists())
      verifyFalse(jq("$win4").exists())

      click(detach.toWidget())
      waitResponse()

      verifyFalse(jq("$win1").exists())
      verifyTrue(jq("$win2").exists())
      verifyFalse(jq("$win3").exists())
      verifyFalse(jq("$win4").exists())

    })
  }
}