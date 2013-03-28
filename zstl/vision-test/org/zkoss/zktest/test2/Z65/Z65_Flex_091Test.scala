
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-091.zul,Flex")
class Z65_Flex_091Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <doublebox hflex="1" value="1.1" vflex="1"/>
            <doublebox height="60px" hflex="1" value="1.1"/>
            <doublebox height="100px" hflex="1" value="1.1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <doublebox hflex="1" value="1.1" vflex="1"/>
            <doublebox height="60px" hflex="1" value="1.1"/>
            <doublebox height="100px" hflex="1" value="1.1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <doublebox hflex="1" mold="rounded" value="1.1" vflex="1"/>
            <doublebox height="60px" hflex="1" mold="rounded" value="1.1"/>
            <doublebox height="100px" hflex="1" mold="rounded" value="1.1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <doublebox hflex="1" mold="rounded" value="1.1" vflex="1"/>
            <doublebox height="60px" hflex="1" mold="rounded" value="1.1"/>
            <doublebox height="100px" hflex="1" mold="rounded" value="1.1"/>
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