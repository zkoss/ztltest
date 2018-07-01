
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-010.zul,Flex")
class Z65_Flex_010Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Panel, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel vflex="1" width="75px">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel vflex="1" width="120px">
                <panelchildren>
                    <div height="100%" style="background:red" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Panel, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel vflex="1" width="75px">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel vflex="1" width="120px">
                <panelchildren>
                    <div height="100%" style="background:red" width="100%">
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