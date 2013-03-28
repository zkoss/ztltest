
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-004.zul,Flex")
class Z65_Flex_004Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Div, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <div hflex="1" style="background:yellow" vflex="1">
                <label value="1"/>
            </div>
            <div height="60px" hflex="1" style="background:cyan">
                <label value="1"/>
            </div>
            <div height="100px" hflex="1" style="background:red">
                <label value="1"/>
            </div>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Div, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <div hflex="1" style="background:yellow" vflex="1">
                <label value="1"/>
            </div>
            <div height="60px" hflex="1" style="background:cyan">
                <label value="1"/>
            </div>
            <div height="100px" hflex="1" style="background:red">
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