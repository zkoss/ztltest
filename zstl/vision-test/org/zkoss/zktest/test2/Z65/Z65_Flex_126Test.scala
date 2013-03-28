
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-126.zul,Flex")
class Z65_Flex_126Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner hflex="1" value="2" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner hflex="1" value="2" vflex="2"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner hflex="1" mold="rounded" value="2" vflex="2"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner hflex="1" mold="rounded" value="2" vflex="2"/>
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