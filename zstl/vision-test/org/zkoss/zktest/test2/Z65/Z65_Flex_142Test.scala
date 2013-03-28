
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-142.zul,Flex")
class Z65_Flex_142Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="data flex test: [listbox,span,hflex=1,hflex=min,hflex=min]" width="480px">
        <listbox>
            <listhead>
                <listheader hflex="1" label="hflex=1"/>
                <listheader hflex="min" label="hflex=min"/>
                <listheader hflex="min" label="hflex=min"/>
            </listhead>
            <listitem>
                <listcell label="item 1" span="2" style="background: cyan"/>
                <listcell label="item 1"/>
            </listitem>
            <listitem>
                <listcell label="item 2"/>
                <listcell label="item 2 desc"/>
                <listcell label="item 2"/>
            </listitem>
            <listitem>
                <listcell label="item 3"/>
                <listcell label="item 3 desc" span="2" style="background: cyan"/>
            </listitem>
        </listbox>
    </window>
    <window border="normal" height="360px"
        title="data flex test: [listbox,hflex=1,hflex=min,hflex=min]" width="480px">
        <listbox>
            <listhead>
                <listheader hflex="1" label="hflex=1"/>
                <listheader hflex="min" label="hflex=min"/>
                <listheader hflex="min" label="hflex=min"/>
            </listhead>
            <listitem>
                <listcell label="item 1"/>
                <listcell label="item 1 desc"/>
                <listcell label="item 1"/>
            </listitem>
            <listitem>
                <listcell label="item 2"/>
                <listcell label="item 2 desc"/>
                <listcell label="item 2"/>
            </listitem>
            <listitem>
                <listcell label="item 3"/>
                <listcell label="item 3 desc"/>
                <listcell label="item 3"/>
            </listitem>
        </listbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="data flex test: [listbox,span,hflex=1,hflex=1,hflex=1]" width="480px">
        <listbox>
            <listhead>
                <listheader hflex="1" label="hflex=1"/>
                <listheader hflex="1" label="hflex=1"/>
                <listheader hflex="1" label="hflex=1"/>
            </listhead>
            <listitem>
                <listcell label="item 1" span="2" style="background: cyan"/>
                <listcell label="item 1"/>
            </listitem>
            <listitem>
                <listcell label="item 2"/>
                <listcell label="item 2 desc"/>
                <listcell label="item 2"/>
            </listitem>
            <listitem>
                <listcell label="item 3"/>
                <listcell label="item 3 desc" span="2" style="background: cyan"/>
            </listitem>
        </listbox>
    </window>
    <window border="normal" height="360px"
        title="data flex test: [listbox,hflex=1,hflex=1,hflex=1]" width="480px">
        <listbox>
            <listhead>
                <listheader hflex="1" label="hflex=1"/>
                <listheader hflex="1" label="hflex=1"/>
                <listheader hflex="1" label="hflex=1"/>
            </listhead>
            <listitem>
                <listcell label="item 1"/>
                <listcell label="item 1 desc"/>
                <listcell label="item 1"/>
            </listitem>
            <listitem>
                <listcell label="item 2"/>
                <listcell label="item 2 desc"/>
                <listcell label="item 2"/>
            </listitem>
            <listitem>
                <listcell label="item 3"/>
                <listcell label="item 3 desc"/>
                <listcell label="item 3"/>
            </listitem>
        </listbox>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}