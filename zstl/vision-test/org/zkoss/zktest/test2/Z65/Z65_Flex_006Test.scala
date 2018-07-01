
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-006.zul,Flex")
class Z65_Flex_006Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><window border="normal" height="360px"
    title="Fit-the-Rest Flexibility: [Panel]" width="480px">
    <panel vflex="1">
        <panelchildren>
            <div height="100%" style="background:yellow" width="100%">
                <label value="1"/>
            </div>
        </panelchildren>
    </panel>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}