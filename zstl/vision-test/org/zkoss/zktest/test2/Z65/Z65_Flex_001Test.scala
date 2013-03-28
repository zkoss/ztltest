
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-001.zul,Flex")
class Z65_Flex_001Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><window border="normal" height="360px"
    title="Fit-the-Rest Flexibility: [Div]" width="480px">
    <div style="background:yellow" vflex="1">
        <div height="100%" style="background:yellow" width="100%">
            <label value="1"/>
        </div>
    </div>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}