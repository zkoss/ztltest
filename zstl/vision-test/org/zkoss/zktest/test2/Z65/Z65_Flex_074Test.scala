
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-074.zul,Flex")
class Z65_Flex_074Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox vflex="1" width="75px">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox vflex="1" width="120px">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
            <combobox hflex="1" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox vflex="1" width="75px">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox vflex="1" width="120px">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox mold="rounded" vflex="1" width="75px">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox mold="rounded" vflex="1" width="120px">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Combobox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
            <combobox hflex="1" mold="rounded" vflex="1">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox mold="rounded" vflex="1" width="75px">
                <comboitem label="apple"/>
                <comboitem label="banana"/>
            </combobox>
            <combobox mold="rounded" vflex="1" width="120px">
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