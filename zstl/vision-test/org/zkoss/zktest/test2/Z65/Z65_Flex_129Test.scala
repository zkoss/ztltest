
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-129.zul,Flex")
class Z65_Flex_129Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Spinner]" width="480px">
        <spinner hflex="1" value="2"/>
    </window>
    <window border="normal" height="360px"
        title="Input HFlex Case: [Spinner, rounded]" width="480px">
        <spinner hflex="1" mold="rounded" value="2"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}