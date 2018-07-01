package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2072.zul")
class B70_ZK_2072Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?init class="org.zkoss.zk.ui.util.Composition" arg0="B70-ZK-2072_1.zul"?>
<zk>
	<div>
		<window self="@define(content)" title="window1" width="100px">
			<window self="@define(content)" title="window2" width="200px"/>
			<window self="@define(detail)" title="window3" width="300px" height="100px"/>
		</window>
	</div>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}