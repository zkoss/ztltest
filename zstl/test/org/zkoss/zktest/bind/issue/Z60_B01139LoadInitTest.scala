


/* Z60_B01139LoadInitTest.scala

	Purpose:
		
	Description:
		
	History:
		Jul 2, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01139LoadInitTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01139LoadInit.zul"/>
"""
    runZTL(zul, () => {

      var liChk = jq("$liChk")
      var changeNameBtn = jq("$changeNameBtn")
      var nameTexb = jq("$nameTexb")
      var nameLbl = jq("$nameLbl")

      `type`(nameTexb.toWidget(), "XYZ")
      waitResponse()
      click(changeNameBtn.toWidget())
      waitResponse()
      verifyEquals("XYZ", nameLbl.toWidget().get("value"))

      `type`(nameTexb.toWidget(), "XXX")
      waitResponse()
      click(liChk.toWidget().$n("real"))
      waitResponse()
      click(changeNameBtn)
      waitResponse()
      verifyEquals("XYZ", nameLbl.toWidget().get("value"))

      `type`(nameTexb.toWidget(), "XXX")
      waitResponse()
      click(liChk.toWidget().$n("real"))
      waitResponse()
      click(changeNameBtn.toWidget())
      waitResponse()
      verifyEquals("XXX", nameLbl.toWidget().get("value"))

    })
  }
}

