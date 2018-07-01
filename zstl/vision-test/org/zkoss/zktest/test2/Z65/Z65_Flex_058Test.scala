
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-058.zul,Flex")
class Z65_Flex_058Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Chosenbox, rounded]" width="480px">
        <chosenbox vflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Chosenbox]" width="480px">
        <chosenbox vflex="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}