package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2869.zul")
class B80_ZK_2869Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      //click the fail button
      click(jq("button").eq(0))
      waitResponse()
      //check that message exists in the 1st label
      verifyEquals("\n            CONTENT\n        ", jq(".z-div .z-label").eq(0).text())
      //click the works button
      click(jq("button").eq(1))
      waitResponse()
      //check that message exists in the both label
      verifyEquals("\n            CONTENT\n        ", jq(".z-div .z-label").eq(0).text())
      verifyEquals("\n            CONTENT\n        ", jq(".z-div .z-label").eq(1).text())
    })
  }
}