
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-103.zul,Flex")
class Z65_Flex_103Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <longbox hflex="1" value="1111111111111" vflex="1"/>
            <longbox height="60px" hflex="1" value="1111111111111"/>
            <longbox height="100px" hflex="1" value="1111111111111"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <longbox hflex="1" value="1111111111111" vflex="1"/>
            <longbox height="60px" hflex="1" value="1111111111111"/>
            <longbox height="100px" hflex="1" value="1111111111111"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <longbox height="60px" hflex="1" mold="rounded" value="1111111111111"/>
            <longbox height="100px" hflex="1" mold="rounded" value="1111111111111"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <longbox height="60px" hflex="1" mold="rounded" value="1111111111111"/>
            <longbox height="100px" hflex="1" mold="rounded" value="1111111111111"/>
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