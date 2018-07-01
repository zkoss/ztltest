
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-122.zul,Flex")
class Z65_Flex_122Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner value="0.5" vflex="1" width="75px"/>
            <doublespinner value="0.5" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <doublespinner hflex="1" value="0.5" vflex="1"/>
            <doublespinner value="0.5" vflex="1" width="75px"/>
            <doublespinner value="0.5" vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner mold="rounded" value="0.5" vflex="1" width="75px"/>
            <doublespinner mold="rounded" value="0.5" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublespinner, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <doublespinner hflex="1" mold="rounded" value="0.5" vflex="1"/>
            <doublespinner mold="rounded" value="0.5" vflex="1" width="75px"/>
            <doublespinner mold="rounded" value="0.5" vflex="1" width="120px"/>
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