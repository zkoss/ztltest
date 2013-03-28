
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-143.zul,Flex")
class Z65_Flex_143Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="data flex test: [listbox,span,hflex=min,hflex=min,hflex=min]" width="480px">
        <listbox>
            <listhead>
                <listheader hflex="min" label="hflex=min"/>
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
        title="data flex test: [listbox,hflex=min,hflex=min,hflex=min]" width="480px">
        <listbox>
            <listhead>
                <listheader hflex="min" label="hflex=min"/>
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
        title="data flex test: [listbox,span,sizedByContent]" width="480px">
        <listbox sizedByContent="true">
            <listhead>
                <listheader label="item 1"/>
                <listheader label="item 2"/>
                <listheader label="item 3"/>
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
        title="data flex test: [listbox,sizedByContent]" width="480px">
        <listbox sizedByContent="true">
            <listhead>
                <listheader label="item 1"/>
                <listheader label="item 2"/>
                <listheader label="item 3"/>
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