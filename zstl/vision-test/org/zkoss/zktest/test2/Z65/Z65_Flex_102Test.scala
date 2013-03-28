
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-102.zul,Flex")
class Z65_Flex_102Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Longbox, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <longbox hflex="1" value="1111111111111" vflex="1"/>
            <longbox hflex="1" value="1111111111111" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Longbox, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <longbox hflex="1" value="1111111111111" vflex="1"/>
            <longbox hflex="1" value="1111111111111" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Longbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Longbox, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="2"/>
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