
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-125.zul,Flex")
class Z65_Flex_125Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner hflex="2" value="2" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner hflex="2" value="2" vflex="1"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner hflex="2" mold="rounded" value="2" vflex="1"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Spinner, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner hflex="2" mold="rounded" value="2" vflex="1"/>
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