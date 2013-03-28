
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-013.zul,Flex")
class Z65_Flex_013Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Window, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <window border="none" hflex="1" vflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </window>
            <window border="none" hflex="1" vflex="2">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </window>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Window, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <window border="none" hflex="1" vflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </window>
            <window border="none" hflex="1" vflex="2">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </window>
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