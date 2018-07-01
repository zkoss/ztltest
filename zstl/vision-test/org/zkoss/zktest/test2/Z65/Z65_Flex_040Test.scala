
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-040.zul,Flex")
class Z65_Flex_040Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Vlayout, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <vlayout hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout vflex="1" width="75px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout vflex="1" width="120px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Vlayout, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <vlayout hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout vflex="1" width="75px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout vflex="1" width="120px">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
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