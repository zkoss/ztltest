
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-132.zul,Flex")
class Z65_Flex_132Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="1" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="1" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="1" vflex="2"/>
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