
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-071.zul,Flex")
class Z65_Flex_071Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="2" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="2" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="2" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="2" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
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