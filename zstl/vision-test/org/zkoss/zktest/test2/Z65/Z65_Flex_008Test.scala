
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-008.zul,Flex")
class Z65_Flex_008Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Panel, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel hflex="1" vflex="2">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Panel, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel hflex="1" vflex="2">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
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