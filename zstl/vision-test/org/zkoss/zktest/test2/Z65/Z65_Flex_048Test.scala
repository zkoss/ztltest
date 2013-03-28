
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-048.zul,Flex")
class Z65_Flex_048Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Vlayout]" width="480px">
        <vlayout height="200px" width="200px">
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
            <bandbox hflex="1" vflex="2">
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
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Vbox]" width="480px">
        <vbox height="200px" width="200px">
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
            <bandbox hflex="1" vflex="2">
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
        </vbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" width="200px">
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
            <bandbox hflex="1" mold="rounded" vflex="2">
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
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Bandbox, Vbox, rounded]" width="480px">
        <vbox height="200px" width="200px">
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
            <bandbox hflex="1" mold="rounded" vflex="2">
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