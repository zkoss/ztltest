/* Z60_B01194NestedVMInitTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 6, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01194NestedVMInitTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01194NestedVMInit.zul"/>
"""
    runZTL(zul, () => {

      var headerNameLb = jq("$headerNameLb")

      var vmsNameTxb = jq("$vmsNameTxb")
      var vmsDescTxb = jq("$vmsDescTxb")
      var vmInnerVmDescTxb = jq("$vmInnerVmDescTxb")
      var vmInnerVmDescLb = jq("$vmInnerVmDescLb")

      var outerNameLb = jq("$outerNameLb")
      var outerDescTxb = jq("$outerDescTxb")

      var text = vmsDescTxb.toWidget().attr("value")
      verifyTrue(text.length() > 0)
      verifyEquals(text, vmInnerVmDescTxb.toWidget().attr("value"))
      verifyEquals(text, vmInnerVmDescLb.toWidget().attr("value"))
      verifyEquals(text, outerDescTxb.toWidget().attr("value"))

      text = "Ian Tsai 1"
      `type`(vmsNameTxb.toWidget(), text)
      waitResponse()
      verifyEquals(text, headerNameLb.toWidget().attr("value"))
      verifyEquals(text, outerNameLb.toWidget().attr("value"))

      text = "AAA"
      `type`(vmsDescTxb.toWidget(), text)
      waitResponse()
      verifyEquals(text, vmInnerVmDescTxb.toWidget().attr("value"))
      verifyEquals(text, vmInnerVmDescLb.toWidget().attr("value"))
      verifyEquals(text, outerDescTxb.toWidget().attr("value"))

      text = "BBB"
      `type`(vmInnerVmDescTxb.toWidget(), text)
      waitResponse()
      verifyEquals(text, vmsDescTxb.toWidget().attr("value"))
      verifyEquals(text, vmInnerVmDescLb.toWidget().attr("value"))
      verifyEquals(text, outerDescTxb.toWidget().attr("value"))

      text = "CCC"
      `type`(outerDescTxb.toWidget(), text)
      waitResponse()
      verifyEquals(text, vmsDescTxb.toWidget().attr("value"))
      verifyEquals(text, vmInnerVmDescLb.toWidget().attr("value"))
      verifyEquals(text, vmInnerVmDescTxb.toWidget().attr("value"))

    })
  }
}
