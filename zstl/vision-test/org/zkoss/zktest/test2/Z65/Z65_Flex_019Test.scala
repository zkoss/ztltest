
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-019.zul,Flex")
class Z65_Flex_019Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Groupbox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <groupbox hflex="1" vflex="1">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
            <groupbox height="60px" hflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
            <groupbox height="100px" hflex="1">
                <div height="100%" style="background:red" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Groupbox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <groupbox hflex="1" vflex="1">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
            <groupbox height="60px" hflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </groupbox>
            <groupbox height="100px" hflex="1">
                <div height="100%" style="background:red" width="100%">
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