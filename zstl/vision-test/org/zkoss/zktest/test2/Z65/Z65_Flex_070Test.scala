
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-070.zul,Flex")
class Z65_Flex_070Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Combobox, rounded]" width="480px">
        <combobox mold="rounded" vflex="1">
            <comboitem label="apple"/>
            <comboitem label="banana"/>
        </combobox>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Combobox]" width="480px">
        <combobox vflex="1">
            <comboitem label="apple"/>
            <comboitem label="banana"/>
        </combobox>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}