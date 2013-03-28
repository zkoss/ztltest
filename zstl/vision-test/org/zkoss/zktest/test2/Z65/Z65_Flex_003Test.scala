
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-003.zul,Flex")
class Z65_Flex_003Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Div, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <div hflex="1" style="background:cyan" vflex="1">
                <label value="1"/>
            </div>
            <div hflex="1" style="background:yellow" vflex="2">
                <label value="1"/>
            </div>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Div, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <div hflex="1" style="background:cyan" vflex="1">
                <label value="1"/>
            </div>
            <div hflex="1" style="background:yellow" vflex="2">
                <label value="1"/>
            </div>
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