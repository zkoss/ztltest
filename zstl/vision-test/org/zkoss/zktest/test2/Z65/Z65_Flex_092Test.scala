
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-092.zul,Flex")
class Z65_Flex_092Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <doublebox hflex="1" value="1.1" vflex="1"/>
            <doublebox value="1.1" vflex="1" width="75px"/>
            <doublebox value="1.1" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <doublebox hflex="1" value="1.1" vflex="1"/>
            <doublebox value="1.1" vflex="1" width="75px"/>
            <doublebox value="1.1" vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <doublebox hflex="1" mold="rounded" value="1.1" vflex="1"/>
            <doublebox mold="rounded" value="1.1" vflex="1" width="75px"/>
            <doublebox mold="rounded" value="1.1" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Doublebox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <doublebox hflex="1" mold="rounded" value="1.1" vflex="1"/>
            <doublebox mold="rounded" value="1.1" vflex="1" width="75px"/>
            <doublebox mold="rounded" value="1.1" vflex="1" width="120px"/>
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