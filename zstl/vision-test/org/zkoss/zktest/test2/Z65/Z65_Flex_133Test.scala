
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-133.zul,Flex")
class Z65_Flex_133Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider height="60px" hflex="1"/>
            <slider height="100px" hflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider height="60px" hflex="1"/>
            <slider height="100px" hflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider height="60px" hflex="1"/>
            <slider height="100px" hflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Slider, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <slider hflex="1" vflex="1"/>
            <slider height="60px" hflex="1"/>
            <slider height="100px" hflex="1"/>
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