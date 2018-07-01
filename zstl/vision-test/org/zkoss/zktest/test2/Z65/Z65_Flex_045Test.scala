
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-045.zul,Flex")
class Z65_Flex_045Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Vbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <vbox hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
            <vbox vflex="1" width="75px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
            <vbox vflex="1" width="120px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Vbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <vbox hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
            <vbox vflex="1" width="75px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
            <vbox vflex="1" width="120px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vbox>
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