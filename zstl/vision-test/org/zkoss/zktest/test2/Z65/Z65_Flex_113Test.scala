
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-113.zul,Flex")
class Z65_Flex_113Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Timebox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <timebox hflex="1" vflex="1"/>
            <timebox hflex="2" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Timebox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <timebox hflex="1" vflex="1"/>
            <timebox hflex="2" vflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Timebox, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <timebox hflex="1" mold="rounded" vflex="1"/>
            <timebox hflex="2" mold="rounded" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Timebox, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <timebox hflex="1" mold="rounded" vflex="1"/>
            <timebox hflex="2" mold="rounded" vflex="1"/>
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