
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-098.zul,Flex")
class Z65_Flex_098Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <intbox hflex="1" value="1" vflex="1"/>
            <intbox value="1" vflex="1" width="75px"/>
            <intbox value="1" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <intbox hflex="1" value="1" vflex="1"/>
            <intbox value="1" vflex="1" width="75px"/>
            <intbox value="1" vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <intbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <intbox mold="rounded" value="1" vflex="1" width="75px"/>
            <intbox mold="rounded" value="1" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Intbox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <intbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <intbox mold="rounded" value="1" vflex="1" width="75px"/>
            <intbox mold="rounded" value="1" vflex="1" width="120px"/>
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