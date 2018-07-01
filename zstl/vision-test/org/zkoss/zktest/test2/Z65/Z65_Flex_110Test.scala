
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-110.zul,Flex")
class Z65_Flex_110Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <textbox hflex="1" value="1" vflex="1"/>
            <textbox value="1" vflex="1" width="75px"/>
            <textbox value="1" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <textbox hflex="1" value="1" vflex="1"/>
            <textbox value="1" vflex="1" width="75px"/>
            <textbox value="1" vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <textbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <textbox mold="rounded" value="1" vflex="1" width="75px"/>
            <textbox mold="rounded" value="1" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Textbox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <textbox hflex="1" mold="rounded" value="1" vflex="1"/>
            <textbox mold="rounded" value="1" vflex="1" width="75px"/>
            <textbox mold="rounded" value="1" vflex="1" width="120px"/>
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