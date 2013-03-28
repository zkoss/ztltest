
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-131.zul,Flex")
class Z65_Flex_131Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="2" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="2" vflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="2" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Slider, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider hflex="2" vflex="1"/>
        </hbox>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}