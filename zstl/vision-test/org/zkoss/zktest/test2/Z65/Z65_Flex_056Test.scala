
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-056.zul,Flex")
class Z65_Flex_056Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Calendar, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <calendar hflex="1" vflex="1"/>
            <calendar vflex="1" width="75px"/>
            <calendar vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Calendar, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <calendar hflex="1" vflex="1"/>
            <calendar vflex="1" width="75px"/>
            <calendar vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Calendar, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <calendar hflex="1" vflex="1"/>
            <calendar vflex="1" width="75px"/>
            <calendar vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Calendar, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <calendar hflex="1" vflex="1"/>
            <calendar vflex="1" width="75px"/>
            <calendar vflex="1" width="120px"/>
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