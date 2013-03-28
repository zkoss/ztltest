
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-028.zul,Flex")
class Z65_Flex_028Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Hlayout, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <hlayout hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hlayout>
            <hlayout hflex="1" vflex="2">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hlayout>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Hlayout, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <hlayout hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hlayout>
            <hlayout hflex="1" vflex="2">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="2" style="background:yellow" vflex="1">
                    <label value="1"/>
                </div>
            </hlayout>
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