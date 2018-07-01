
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-017.zul,Flex")
class Z65_Flex_017Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Groupbox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <groupbox hflex="1" vflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
            <groupbox hflex="2" vflex="1">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Groupbox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <groupbox hflex="1" vflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
            <groupbox hflex="2" vflex="1">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
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