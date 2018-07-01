
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-072.zul,Flex")
class Z65_Flex_072Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="1" vflex="2">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Vbox]" width="480px">
        <vbox height="200px" width="200px">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="1" vflex="2">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="1" mold="rounded" vflex="2">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Combobox, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox hflex="1" mold="rounded" vflex="2">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
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