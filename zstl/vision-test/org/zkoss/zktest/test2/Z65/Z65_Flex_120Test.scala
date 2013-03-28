
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-120.zul,Flex")
class Z65_Flex_120Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner hflex="1" value="0.5" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner hflex="1" value="0.5" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Doublespinner, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="2"/>
        </vbox>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}