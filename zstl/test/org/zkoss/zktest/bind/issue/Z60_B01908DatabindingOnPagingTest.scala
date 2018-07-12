/* Z60_B01908DatabindingOnPagingTest.scala

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
class Z60_B01908DatabindingOnPagingTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01908DatabindingOnPaging.zul"/>
"""

    runZTL(zul, () => {
      val pg = jq("$pg").toWidget();
      val lab1 = jq("$lab1").toWidget();
      verifyEquals(3L, pg.attr("activePage"))
      verifyEquals(10L, pg.attr("pageSize"))
      verifyEquals(100L, pg.attr("totalSize"))
      verifyEquals("3", lab1.attr("value"))
      
//      pg.set("setActivePage", 4)
//      waitResponse()
//      verifyEquals(4L, pg.attr("activePage"))
//      verifyEquals("4", lab1.attr("value"))
    })

  }
}