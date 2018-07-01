
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-021.zul,Flex")
class Z65_Flex_021Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><window border="normal" height="360px"
    title="Fit-the-Rest Flexibility: [Tabbox]" width="480px">
    <tabbox vflex="1">
        <tabs>
            <tab label="case"/>
        </tabs>
        <tabpanels>
            <tabpanel>
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </tabpanel>
        </tabpanels>
    </tabbox>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}