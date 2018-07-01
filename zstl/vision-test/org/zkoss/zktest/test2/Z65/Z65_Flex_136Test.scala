
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-136.zul,Flex")
class Z65_Flex_136Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk>
	<window border="normal" height="360px" width="480px">
		<hlayout hflex="1" vflex="1">
			<cardlayout hflex="1" />
			<cardlayout hflex="2" />
		</hlayout>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}