
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-068.zul,Flex")
class Z65_Flex_068Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Colorbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <colorbox hflex="1" vflex="1"/>
            <colorbox vflex="1" width="75px"/>
            <colorbox vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Colorbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <colorbox hflex="1" vflex="1"/>
            <colorbox vflex="1" width="75px"/>
            <colorbox vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Colorbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <colorbox hflex="1" vflex="1"/>
            <colorbox vflex="1" width="75px"/>
            <colorbox vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Colorbox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <colorbox hflex="1" vflex="1"/>
            <colorbox vflex="1" width="75px"/>
            <colorbox vflex="1" width="120px"/>
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