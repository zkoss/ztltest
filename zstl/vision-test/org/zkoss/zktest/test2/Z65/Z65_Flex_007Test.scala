
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-007.zul,Flex")
class Z65_Flex_007Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Panel, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel hflex="2" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Panel, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel hflex="2" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
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