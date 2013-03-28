
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-119.zul,Flex")
class Z65_Flex_119Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner hflex="2" value="0.5" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner hflex="2" value="0.5" vflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner hflex="2" mold="rounded" value="0.5" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner hflex="2" mold="rounded" value="0.5" vflex="1"/>
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