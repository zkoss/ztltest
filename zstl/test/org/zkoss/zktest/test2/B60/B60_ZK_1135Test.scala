package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1135.zul")
class B60_ZK_1135Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>
	You should see notification message in IE8, otherwise it is a bug.
	</div>
	<button label="show notification">
		<attribute name="onClick"><![CDATA[
			Clients.showNotification("Disappearing notification in IE8");
		]]></attribute>
	</button>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:eq(0)"))
      waitResponse()
      
      verifyTrue("You should see notification message", jq(".z-notification").exists)
    })
    
  }
}