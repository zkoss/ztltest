
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-085.zul,Flex")
class Z65_Flex_085Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <decimalbox hflex="1" value="1111111111111" vflex="1"/>
            <decimalbox height="60px" hflex="1" value="1111111111111"/>
            <decimalbox height="100px" hflex="1" value="1111111111111"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <decimalbox hflex="1" value="1111111111111" vflex="1"/>
            <decimalbox height="60px" hflex="1" value="1111111111111"/>
            <decimalbox height="100px" hflex="1" value="1111111111111"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <decimalbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <decimalbox height="60px" hflex="1" mold="rounded" value="1111111111111"/>
            <decimalbox height="100px" hflex="1" mold="rounded" value="1111111111111"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <decimalbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <decimalbox height="60px" hflex="1" mold="rounded" value="1111111111111"/>
            <decimalbox height="100px" hflex="1" mold="rounded" value="1111111111111"/>
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