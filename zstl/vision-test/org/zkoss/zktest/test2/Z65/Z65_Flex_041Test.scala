
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-041.zul,Flex")
class Z65_Flex_041Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><window border="normal" height="360px"
    title="Fit-the-Rest Flexibility: [Vbox]" width="480px">
    <vbox vflex="1" width="200px">
        <div hflex="1" style="background:cyan" vflex="1">
            <label value="1"/>
        </div>
        <div hflex="1" style="background:yellow" vflex="2">
            <label value="1"/>
        </div>
    </vbox>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}