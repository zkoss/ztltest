
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-086.zul,Flex")
class Z65_Flex_086Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <decimalbox hflex="1" value="1111111111111" vflex="1"/>
            <decimalbox value="1111111111111" vflex="1" width="75px"/>
            <decimalbox value="1111111111111" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <decimalbox hflex="1" value="1111111111111" vflex="1"/>
            <decimalbox value="1111111111111" vflex="1" width="75px"/>
            <decimalbox value="1111111111111" vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <decimalbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <decimalbox mold="rounded" value="1111111111111" vflex="1" width="75px"/>
            <decimalbox mold="rounded" value="1111111111111" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Decimalbox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <decimalbox hflex="1" mold="rounded" value="1111111111111" vflex="1"/>
            <decimalbox mold="rounded" value="1111111111111" vflex="1" width="75px"/>
            <decimalbox mold="rounded" value="1111111111111" vflex="1" width="120px"/>
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