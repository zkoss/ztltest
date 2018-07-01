
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-111.zul,Flex")
class Z65_Flex_111Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Textbox]" width="480px">
        <textbox hflex="1" value="1"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Textbox, rounded]" width="480px">
        <textbox hflex="1" mold="rounded" value="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}