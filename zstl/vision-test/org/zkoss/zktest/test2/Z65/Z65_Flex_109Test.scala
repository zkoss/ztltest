
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-109.zul,Flex")
class Z65_Flex_109Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <textbox hflex="1" value="1" vflex="1"/>
            <textbox height="60px" hflex="1" value="1"/>
            <textbox height="100px" hflex="1" value="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <textbox hflex="1" value="1" vflex="1"/>
            <textbox height="60px" hflex="1" value="1"/>
            <textbox height="100px" hflex="1" value="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <textbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <textbox height="60px" hflex="1" mold="rounded" value="1"/>
            <textbox height="100px" hflex="1" mold="rounded" value="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <textbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <textbox height="60px" hflex="1" mold="rounded" value="1"/>
            <textbox height="100px" hflex="1" mold="rounded" value="1"/>
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