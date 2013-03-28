
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-089.zul,Flex")
class Z65_Flex_089Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublebox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <doublebox hflex="1" value="1.1" vflex="1"/>
            <doublebox hflex="2" value="1.1" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublebox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <doublebox hflex="1" value="1.1" vflex="1"/>
            <doublebox hflex="2" value="1.1" vflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublebox, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <doublebox hflex="1" mold="rounded" value="1.1" vflex="1"/>
            <doublebox hflex="2" mold="rounded" value="1.1" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublebox, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <doublebox hflex="1" mold="rounded" value="1.1" vflex="1"/>
            <doublebox hflex="2" mold="rounded" value="1.1" vflex="1"/>
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