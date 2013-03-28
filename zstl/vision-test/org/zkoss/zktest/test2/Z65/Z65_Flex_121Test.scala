
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-121.zul,Flex")
class Z65_Flex_121Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner height="60px" hflex="1" value="0.5"/>
            <doublespinner height="100px" hflex="1" value="0.5"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner height="60px" hflex="1" value="0.5"/>
            <doublespinner height="100px" hflex="1" value="0.5"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner height="60px" hflex="1" mold="rounded" value="0.5"/>
            <doublespinner height="100px" hflex="1" mold="rounded" value="0.5"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner height="60px" hflex="1" mold="rounded" value="0.5"/>
            <doublespinner height="100px" hflex="1" mold="rounded" value="0.5"/>
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