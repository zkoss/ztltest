
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-009.zul,Flex")
class Z65_Flex_009Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Panel, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel height="60px" hflex="1">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel height="100px" hflex="1">
                <panelchildren>
                    <div height="100%" style="background:red" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Panel, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <panel hflex="1" vflex="1">
                <panelchildren>
                    <div height="100%" style="background:yellow" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel height="60px" hflex="1">
                <panelchildren>
                    <div height="100%" style="background:cyan" width="100%">
                        <label value="1"/>
                    </div>
                </panelchildren>
            </panel>
            <panel height="100px" hflex="1">
                <panelchildren>
                    <div height="100%" style="background:red" width="100%">
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