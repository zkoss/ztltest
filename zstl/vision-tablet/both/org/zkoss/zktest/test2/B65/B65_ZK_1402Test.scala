

package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1402.zul,Tablet,VisionTest")
class B65_ZK_1402Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk>
	<window title="Simple Title" border="normal" width="300px" height="300px">
		<borderlayout>
			<center title="Center">Center Content</center>
			<north size="20%" title="North">North Content</north>
			<south size="20%" title="South">South Content</south>
			<east size="20%" title="East">East Content</east>
			<west size="20%" title="West">West Content</west>
		</borderlayout>
	</window>
</zk>
"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}