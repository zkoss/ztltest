
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-046.zul,Flex")
class Z65_Flex_046Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Bandbox, rounded]" width="480px">
        <bandbox mold="rounded" vflex="1">
            <bandpopup>
                <vbox>
                    <listbox width="200px">
                        <listhead>
                            <listheader label="Name"/>
                        </listhead>
                        <listitem>
                            <listcell label="John"/>
                        </listitem>
                    </listbox>
                </vbox>
            </bandpopup>
        </bandbox>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Bandbox]" width="480px">
        <bandbox vflex="1">
            <bandpopup>
                <vbox>
                    <listbox width="200px">
                        <listhead>
                            <listheader label="Name"/>
                        </listhead>
                        <listitem>
                            <listcell label="John"/>
                        </listitem>
                    </listbox>
                </vbox>
            </bandpopup>
        </bandbox>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}