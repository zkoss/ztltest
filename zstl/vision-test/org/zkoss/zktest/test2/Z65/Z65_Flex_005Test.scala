
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-005.zul,Flex")
class Z65_Flex_005Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Div, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <div hflex="1" style="background:yellow" vflex="1">
                <label value="1"/>
            </div>
            <div style="background:cyan" vflex="1" width="75px">
                <label value="1"/>
            </div>
            <div style="background:red" vflex="1" width="120px">
                <label value="1"/>
            </div>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Div, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <div hflex="1" style="background:yellow" vflex="1">
                <label value="1"/>
            </div>
            <div style="background:cyan" vflex="1" width="75px">
                <label value="1"/>
            </div>
            <div style="background:red" vflex="1" width="120px">
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