/* Z60_B00758IndirectTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 20, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

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
class Z60_B00758IndirectTest extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
      <include src="/bind/issue/B00758Indirect.zul"/>
    }

    runZTL(zul, () => {

      var grid = jq("$grid")
      var btn1 = jq("$btn1")
      var btn2 = jq("$btn2")
      var rows = grid.find("@row")
      verifyEquals("First0", rows.eq(0).find("@textbox").eq(0).toWidget().get("value"))
      verifyEquals("Last0", rows.eq(0).find("@textbox").eq(1).toWidget().get("value"))
      verifyEquals("First0 Last0", rows.eq(0).find("@label").toWidget().get("value"))

      click(btn1.toWidget())
      waitResponse()
      rows = grid.find("@row")
      verifyEquals("Tom", rows.eq(0).find("@textbox").eq(0).toWidget().get("value"))
      verifyEquals("Last0", rows.eq(0).find("@textbox").eq(1).toWidget().get("value"))
      verifyEquals("Tom Last0", rows.eq(0).find("@label").toWidget().get("value"))

      click(btn2.toWidget())
      waitResponse()
      rows = grid.find("@row")
      verifyEquals("Henri", rows.eq(0).find("@textbox").eq(0).toWidget().get("value"))
      verifyEquals("Chen", rows.eq(0).find("@textbox").eq(1).toWidget().get("value"))
      verifyEquals("Henri Chen", rows.eq(0).find("@label").toWidget().get("value"))

    })
  }
}
