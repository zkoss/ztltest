
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-097.zul,Flex")
class Z65_Flex_097Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <intbox hflex="1" value="1" vflex="1"/>
            <intbox height="60px" hflex="1" value="1"/>
            <intbox height="100px" hflex="1" value="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <intbox hflex="1" value="1" vflex="1"/>
            <intbox height="60px" hflex="1" value="1"/>
            <intbox height="100px" hflex="1" value="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <intbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <intbox height="60px" hflex="1" mold="rounded" value="1"/>
            <intbox height="100px" hflex="1" mold="rounded" value="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <intbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <intbox height="60px" hflex="1" mold="rounded" value="1"/>
            <intbox height="100px" hflex="1" mold="rounded" value="1"/>
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