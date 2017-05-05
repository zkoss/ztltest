/* Z60_B01795NestedTemplateTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 29, 2013 Created by Kuro Chung

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author kuro
 */
@Tags(tags = "zbind")
class Z60_B01795NestedTemplateTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01795NestedTemplate.zul"/>
"""

    runZTL(zul, () => {
      val box1s = jq("@grid @label")
      verifyEquals("[AJAX]", box1s.eq(0).toWidget.get("value"))
      verifyEquals("[AJAX]", box1s.eq(1).toWidget.get("value"))
      verifyEquals("[AJAX]", box1s.eq(2).toWidget.get("value"))
      verifyEquals("[Java, C]", box1s.eq(3).toWidget.get("value"))
      verifyEquals("[Java, C]", box1s.eq(4).toWidget.get("value"))
      verifyEquals("[Java, C]", box1s.eq(5).toWidget.get("value"))
    })
  }
}