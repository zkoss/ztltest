
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-042.zul,Flex")
class Z65_Flex_042Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Vbox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <vbox hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
            <vbox hflex="2" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Vbox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <vbox hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
            <vbox hflex="2" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
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