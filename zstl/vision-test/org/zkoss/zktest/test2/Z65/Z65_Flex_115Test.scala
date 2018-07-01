
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-115.zul,Flex")
class Z65_Flex_115Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <timebox hflex="1" vflex="1"/>
            <timebox height="60px" hflex="1"/>
            <timebox height="100px" hflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <timebox hflex="1" vflex="1"/>
            <timebox height="60px" hflex="1"/>
            <timebox height="100px" hflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <timebox hflex="1" mold="rounded" vflex="1"/>
            <timebox height="60px" hflex="1" mold="rounded"/>
            <timebox height="100px" hflex="1" mold="rounded"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <timebox hflex="1" mold="rounded" vflex="1"/>
            <timebox height="60px" hflex="1" mold="rounded"/>
            <timebox height="100px" hflex="1" mold="rounded"/>
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