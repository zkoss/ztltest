
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-014.zul,Flex")
class Z65_Flex_014Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Window, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <window border="none" hflex="1" vflex="1">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </window>
            <window border="none" height="60px" hflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </window>
            <window border="none" height="100px" hflex="1">
                <div height="100%" style="background:red" width="100%">
                    <label value="1"/>
                </div>
            </window>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Window, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <window border="none" hflex="1" vflex="1">
                <div height="100%" style="background:yellow" width="100%">
                    <label value="1"/>
                </div>
            </window>
            <window border="none" height="60px" hflex="1">
                <div height="100%" style="background:cyan" width="100%">
                    <label value="1"/>
                </div>
            </window>
            <window border="none" height="100px" hflex="1">
                <div height="100%" style="background:red" width="100%">
                    <label value="1"/>
                </div>
            </window>
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