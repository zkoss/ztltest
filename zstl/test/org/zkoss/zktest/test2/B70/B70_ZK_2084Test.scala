package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2084.zul")
class B70_ZK_2084Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>click 'up' and 'down' in each double spinner, then should see '0.0', '0.0', '0.00'</div>
	<doublespinner />
	<doublespinner step="0.1" />
	<doublespinner step="0.01" />
</zk>"""  
  runZTL(zscript,
    () => {
      
      List("0.0", "0.0", "0.00").zipWithIndex foreach { case (result, index) =>
        val ds = jq(".z-doublespinner").eq(index).toWidget()
        click(ds.$n("btn-up"))
        waitResponse()
        
        click(ds.$n("btn-down"))
        waitResponse()
        
        verifyTrue("should see " + result, ds.$n("real").get("value") == result)
      }
    })
    
  }
}