
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-104.zul,Flex")
class Z65_Flex_104Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <longbox hflex="1" value="1111111111111" vflex="1"/>
            <longbox value="1111111111111" vflex="1" width="75px"/>
            <longbox value="1111111111111" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <longbox hflex="1" value="1111111111111" vflex="1"/>
            <longbox value="1111111111111" vflex="1" width="75px"/>
            <longbox value="1111111111111" vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <longbox mold="rounded" value="1111111111111" vflex="1" width="75px"/>
            <longbox mold="rounded" value="1111111111111" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Longbox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <longbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <longbox mold="rounded" value="1111111111111" vflex="1" width="75px"/>
            <longbox mold="rounded" value="1111111111111" vflex="1" width="120px"/>
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