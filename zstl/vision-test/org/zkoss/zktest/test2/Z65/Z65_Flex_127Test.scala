
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-127.zul,Flex")
class Z65_Flex_127Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner height="60px" hflex="1" value="2"/>
            <spinner height="100px" hflex="1" value="2"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <spinner hflex="1" value="2" vflex="1"/>
            <spinner height="60px" hflex="1" value="2"/>
            <spinner height="100px" hflex="1" value="2"/>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner height="60px" hflex="1" mold="rounded" value="2"/>
            <spinner height="100px" hflex="1" mold="rounded" value="2"/>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Spinner, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <spinner hflex="1" mold="rounded" value="2" vflex="1"/>
            <spinner height="60px" hflex="1" mold="rounded" value="2"/>
            <spinner height="100px" hflex="1" mold="rounded" value="2"/>
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