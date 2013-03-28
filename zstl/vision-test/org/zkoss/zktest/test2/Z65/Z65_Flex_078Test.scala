
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-078.zul,Flex")
class Z65_Flex_078Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Datebox, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <datebox hflex="1" vflex="1"/>
            <datebox hflex="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Datebox, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <datebox hflex="1" vflex="1"/>
            <datebox hflex="1" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Datebox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <datebox hflex="1" mold="rounded" vflex="1"/>
            <datebox hflex="1" mold="rounded" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Datebox, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <datebox hflex="1" mold="rounded" vflex="1"/>
            <datebox hflex="1" mold="rounded" vflex="2"/>
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