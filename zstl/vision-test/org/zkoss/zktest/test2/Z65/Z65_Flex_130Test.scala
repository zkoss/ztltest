
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-130.zul,Flex")
class Z65_Flex_130Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Slider, rounded]" width="480px">
        <slider vflex="1" width="207px"/>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Slider]" width="480px">
        <slider vflex="1" width="207px"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}