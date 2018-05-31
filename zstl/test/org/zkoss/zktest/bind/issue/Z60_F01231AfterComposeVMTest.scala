/* Z60_F01231AfterComposeVMTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 6, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F01231AfterComposeVMTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F01231AfterComposeVM.zul"/>
"""

    runZTL(zul, () => {

      var myWin = jq("$myWin")
      var headerLb = jq("$headerLb")
      var nameLb = jq("$nameLb")
      var descTxb = jq("$descTxb")

      verifyEquals("AAAA", myWin.toWidget().get("title"))
      verifyEquals("This is a label", headerLb.toWidget().get("value"))
      verifyEquals("admin", nameLb.toWidget().get("value"))
      verifyEquals("this is desc", descTxb.toWidget().get("value"))

    })
  }
}
