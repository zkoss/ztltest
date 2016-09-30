package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2096.zul")
class B70_ZK_2096Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      val btn = jq(".z-button")
      
      1 to 5 foreach { n =>
      	click(btn)
      	waitResponse()
      }
      verifyTrue("the z-treecols-bar should not be in front of treecol", !jq("[id$=hdfaker-bar] + [id$=hdfaker]").exists)
    })
    
  }
}