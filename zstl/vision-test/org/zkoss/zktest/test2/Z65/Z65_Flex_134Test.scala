
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-134.zul,Flex")
class Z65_Flex_134Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <slider hflex="1" vflex="1"/>
            <slider vflex="1" width="75px"/>
            <slider vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <slider hflex="1" vflex="1"/>
            <slider vflex="1" width="75px"/>
            <slider vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <slider hflex="1" vflex="1"/>
            <slider vflex="1" width="75px"/>
            <slider vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <slider hflex="1" vflex="1"/>
            <slider vflex="1" width="75px"/>
            <slider vflex="1" width="120px"/>
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