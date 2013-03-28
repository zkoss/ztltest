
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-039.zul,Flex")
class Z65_Flex_039Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Vlayout, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <vlayout hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout height="60px" hflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout height="100px" hflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Vlayout, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <vlayout hflex="1" vflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout height="60px" hflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
            <vlayout height="100px" hflex="1">
                <div hflex="1" style="background:cyan" vflex="1">
                    <label value="1"/>
                </div>
                <div hflex="1" style="background:yellow" vflex="2">
                    <label value="1"/>
                </div>
            </vlayout>
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