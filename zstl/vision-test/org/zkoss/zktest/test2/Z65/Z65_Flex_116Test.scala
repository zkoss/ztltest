
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-116.zul,Flex")
class Z65_Flex_116Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <timebox hflex="1" vflex="1"/>
            <timebox vflex="1" width="75px"/>
            <timebox vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <timebox hflex="1" vflex="1"/>
            <timebox vflex="1" width="75px"/>
            <timebox vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <timebox hflex="1" mold="rounded" vflex="1"/>
            <timebox mold="rounded" vflex="1" width="75px"/>
            <timebox mold="rounded" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Timebox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <timebox hflex="1" mold="rounded" vflex="1"/>
            <timebox mold="rounded" vflex="1" width="75px"/>
            <timebox mold="rounded" vflex="1" width="120px"/>
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