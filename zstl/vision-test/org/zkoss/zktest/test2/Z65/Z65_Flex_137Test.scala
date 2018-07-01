
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-137.zul,Flex")
class Z65_Flex_137Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk>
	<vlayout hflex="1" vflex="1">
		<slider />
	</vlayout>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}