
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-062.zul,Flex")
class Z65_Flex_062Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Chosenbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox vflex="1" width="75px"/>
            <chosenbox vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Chosenbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox vflex="1" width="75px"/>
            <chosenbox vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Chosenbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox vflex="1" width="75px"/>
            <chosenbox vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Chosenbox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox vflex="1" width="75px"/>
            <chosenbox vflex="1" width="120px"/>
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