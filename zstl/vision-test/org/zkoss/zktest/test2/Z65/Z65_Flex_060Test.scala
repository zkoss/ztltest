
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-060.zul,Flex")
class Z65_Flex_060Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Chosenbox, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox hflex="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Chosenbox, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox hflex="1" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Chosenbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox hflex="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Chosenbox, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <chosenbox hflex="1" vflex="1"/>
            <chosenbox hflex="1" vflex="2"/>
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