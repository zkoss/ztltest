
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-047.zul,Flex")
class Z65_Flex_047Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <bandbox hflex="1" vflex="1">
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
            <bandbox hflex="2" vflex="1">
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
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <bandbox hflex="1" vflex="1">
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
            <bandbox hflex="2" vflex="1">
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
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <bandbox hflex="1" mold="rounded" vflex="1">
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
            <bandbox hflex="2" mold="rounded" vflex="1">
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
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <bandbox hflex="1" mold="rounded" vflex="1">
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
            <bandbox hflex="2" mold="rounded" vflex="1">
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