
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-011.zul,Flex")
class Z65_Flex_011Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><window border="normal" height="360px"
    title="Fit-the-Rest Flexibility: [Window]" width="480px">
    <window border="none" vflex="1">
        <div height="100%" style="background:yellow" width="100%">
            <label value="1"/>
        </div>
    </window>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}