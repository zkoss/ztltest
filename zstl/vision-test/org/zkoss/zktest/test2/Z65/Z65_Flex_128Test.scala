
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-128.zul,Flex")
class Z65_Flex_128Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner value="2" vflex="1" width="75px"/>
            <spinner value="2" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner value="2" vflex="1" width="75px"/>
            <spinner value="2" vflex="1" width="120px"/>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner mold="rounded" value="2" vflex="1" width="75px"/>
            <spinner mold="rounded" value="2" vflex="1" width="120px"/>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner mold="rounded" value="2" vflex="1" width="75px"/>
            <spinner mold="rounded" value="2" vflex="1" width="120px"/>
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