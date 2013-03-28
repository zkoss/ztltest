
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-016.zul,Flex")
class Z65_Flex_016Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><window border="normal" height="360px"
    title="Fit-the-Rest Flexibility: [Groupbox]" width="480px">
    <groupbox vflex="1">
        <div height="100%" style="background:yellow" width="100%">
            <label value="1"/>
        </div>
    </groupbox>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}