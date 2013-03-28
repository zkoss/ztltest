
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-035.zul,Flex")
class Z65_Flex_035Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Hbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <hbox hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hbox>
            <hbox vflex="1" width="75px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hbox>
            <hbox vflex="1" width="120px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hbox>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Hbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <hbox hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hbox>
            <hbox vflex="1" width="75px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hbox>
            <hbox vflex="1" width="120px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hbox>
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