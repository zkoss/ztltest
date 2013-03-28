
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-054.zul,Flex")
class Z65_Flex_054Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <calendar hflex="1" vflex="1"/>
            <calendar hflex="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <calendar hflex="1" vflex="1"/>
            <calendar hflex="1" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <calendar hflex="1" vflex="1"/>
            <calendar hflex="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <calendar hflex="1" vflex="1"/>
            <calendar hflex="1" vflex="2"/>
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