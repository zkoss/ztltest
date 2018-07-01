
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-050.zul,Flex")
class Z65_Flex_050Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Bandbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
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
            <bandbox vflex="1" width="75px">
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
            <bandbox vflex="1" width="120px">
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
        title="minimum Flex: [Bandbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
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
            <bandbox vflex="1" width="75px">
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
            <bandbox vflex="1" width="120px">
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
        title="minimum Flex: [Bandbox, Vlayout, rounded]" width="480px">
        <vlayout height="200px" hflex="min">
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
            <bandbox mold="rounded" vflex="1" width="75px">
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
            <bandbox mold="rounded" vflex="1" width="120px">
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
        title="minimum Flex: [Bandbox, Vbox, rounded]" width="480px">
        <vbox height="200px" hflex="min">
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
            <bandbox mold="rounded" vflex="1" width="75px">
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
            <bandbox mold="rounded" vflex="1" width="120px">
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