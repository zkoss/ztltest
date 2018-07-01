
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-002.zul,Flex")
class Z65_Flex_002Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Div, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <div hflex="1" style="background:cyan" vflex="1">
                <label value="1"/>
            </div>
            <div hflex="2" style="background:yellow" vflex="1">
                <label value="1"/>
            </div>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Div, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <div hflex="1" style="background:cyan" vflex="1">
                <label value="1"/>
            </div>
            <div hflex="2" style="background:yellow" vflex="1">
                <label value="1"/>
            </div>
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