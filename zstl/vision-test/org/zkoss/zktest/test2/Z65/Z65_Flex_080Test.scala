
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-080.zul,Flex")
class Z65_Flex_080Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Datebox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <datebox hflex="1" vflex="1"/>
            <datebox vflex="1" width="75px"/>
            <datebox vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Datebox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <datebox hflex="1" vflex="1"/>
            <datebox vflex="1" width="75px"/>
            <datebox vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Datebox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <datebox hflex="1" mold="rounded" vflex="1"/>
            <datebox mold="rounded" vflex="1" width="75px"/>
            <datebox mold="rounded" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Datebox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <datebox hflex="1" mold="rounded" vflex="1"/>
            <datebox mold="rounded" vflex="1" width="75px"/>
            <datebox mold="rounded" vflex="1" width="120px"/>
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