
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-049.zul,Flex")
class Z65_Flex_049Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Bandbox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
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
            <bandbox height="60px" hflex="1">
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
            <bandbox height="100px" hflex="1">
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
        title="minimum Flex: [Bandbox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
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
            <bandbox height="60px" hflex="1">
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
            <bandbox height="100px" hflex="1">
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
        title="minimum Flex: [Bandbox, Hlayout, rounded]" width="480px">
        <hlayout vflex="min" width="200px">
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
            <bandbox height="60px" hflex="1" mold="rounded">
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
            <bandbox height="100px" hflex="1" mold="rounded">
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
        title="minimum Flex: [Bandbox, Hbox, rounded]" width="480px">
        <hbox vflex="min" width="200px">
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
            <bandbox height="60px" hflex="1" mold="rounded">
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
            <bandbox height="100px" hflex="1" mold="rounded">
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