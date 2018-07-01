
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-065.zul,Flex")
class Z65_Flex_065Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Colorbox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <colorbox hflex="1" vflex="1"/>
            <colorbox hflex="2" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Colorbox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <colorbox hflex="1" vflex="1"/>
            <colorbox hflex="2" vflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Colorbox, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <colorbox hflex="1" vflex="1"/>
            <colorbox hflex="2" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Colorbox, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <colorbox hflex="1" vflex="1"/>
            <colorbox hflex="2" vflex="1"/>
        </hbox>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}