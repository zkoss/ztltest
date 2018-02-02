package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * 
 * @author christopher
 */
@Tags(tags = "B70-ZK-3053.zul")
class B70_ZK_3053Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      //click the left button
      click(jq("button").eq(0))
      waitResponse(true)
      //check no message exist in zk.log
      verifyEquals("", getZKLog)
    })
  }
}
