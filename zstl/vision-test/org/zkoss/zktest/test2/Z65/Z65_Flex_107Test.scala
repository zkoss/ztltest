
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-107.zul,Flex")
class Z65_Flex_107Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Textbox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <textbox hflex="1" value="1" vflex="1"/>
            <textbox hflex="2" value="1" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Textbox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <textbox hflex="1" value="1" vflex="1"/>
            <textbox hflex="2" value="1" vflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Textbox, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <textbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <textbox hflex="2" mold="rounded" value="1" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Textbox, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <textbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <textbox hflex="2" mold="rounded" value="1" vflex="1"/>
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