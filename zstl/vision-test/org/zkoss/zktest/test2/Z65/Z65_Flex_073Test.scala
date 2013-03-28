
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-073.zul,Flex")
class Z65_Flex_073Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="60px" hflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="100px" hflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="60px" hflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="100px" hflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="60px" hflex="1" mold="rounded">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="100px" hflex="1" mold="rounded">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="60px" hflex="1" mold="rounded">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox height="100px" hflex="1" mold="rounded">
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