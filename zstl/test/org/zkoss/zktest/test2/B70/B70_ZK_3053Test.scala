package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

/**
 * 
 * @author christopher
 */
@Tags(tags = "B70-ZK-3053.zul")
class B70_ZK_3053Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
<include src="test2/B70-ZK-3053.zul"/>
"""  
  runZTL(zscript,
    () => {
      //click the left button
      click(jq("button").eq(0))
      waitResponse(true)
      //check no message exist in zk.log
      verifyEquals(null, getZKLog())
    })
  }
}