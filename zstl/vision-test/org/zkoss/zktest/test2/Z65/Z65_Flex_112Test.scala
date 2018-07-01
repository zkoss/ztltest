
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-112.zul,Flex")
class Z65_Flex_112Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Timebox, rounded]" width="480px">
        <timebox mold="rounded" vflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Timebox]" width="480px">
        <timebox vflex="1"/>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}