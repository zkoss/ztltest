
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-140.zul,Flex")
class Z65_Flex_140Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="data flex test: [grid,span,hflex=min,hflex=min,hflex=min]" width="480px">
        <grid>
            <columns>
                <column hflex="min" label="hflex=min"/>
                <column hflex="min" label="hflex=min"/>
                <column hflex="min" label="hflex=min"/>
            </columns>
            <rows>
                <row>
                    <cell colspan="2" style="background: cyan">
                        <label value="item 1"/>
                    </cell>
                    <label value="item 1"/>
                </row>
                <row>
                    <label value="item 2"/>
                    <label value="item 2 desc"/>
                    <label value="item 2"/>
                </row>
                <row>
                    <label value="item 3"/>
                    <cell colspan="2" style="background: cyan">
                        <label value="item 3 desc"/>
                    </cell>
                </row>
            </rows>
        </grid>
    </window>
    <window border="normal" height="360px"
        title="data flex test: [grid,hflex=min,hflex=min,hflex=min]" width="480px">
        <grid>
            <columns>
                <column hflex="min" label="hflex=min"/>
                <column hflex="min" label="hflex=min"/>
                <column hflex="min" label="hflex=min"/>
            </columns>
            <rows>
                <row>
                    <label value="item 1"/>
                    <label value="item 1 desc"/>
                    <label value="item 1"/>
                </row>
                <row>
                    <label value="item 2"/>
                    <label value="item 2 desc"/>
                    <label value="item 2"/>
                </row>
                <row>
                    <label value="item 3"/>
                    <label value="item 3 desc"/>
                    <label value="item 3"/>
                </row>
            </rows>
        </grid>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="data flex test: [grid,span,sizedByContent]" width="480px">
        <grid sizedByContent="true">
            <columns>
                <column label="item 1"/>
                <column label="item 2"/>
                <column label="item 3"/>
            </columns>
            <rows>
                <row>
                    <cell colspan="2" style="background: cyan">
                        <label value="item 1"/>
                    </cell>
                    <label value="item 1"/>
                </row>
                <row>
                    <label value="item 2"/>
                    <label value="item 2 desc"/>
                    <label value="item 2"/>
                </row>
                <row>
                    <label value="item 3"/>
                    <cell colspan="2" style="background: cyan">
                        <label value="item 3 desc"/>
                    </cell>
                </row>
            </rows>
        </grid>
    </window>
    <window border="normal" height="360px"
        title="data flex test: [grid,sizedByContent]" width="480px">
        <grid sizedByContent="true">
            <columns>
                <column label="item 1"/>
                <column label="item 2"/>
                <column label="item 3"/>
            </columns>
            <rows>
                <row>
                    <label value="item 1"/>
                    <label value="item 1 desc"/>
                    <label value="item 1"/>
                </row>
                <row>
                    <label value="item 2"/>
                    <label value="item 2 desc"/>
                    <label value="item 2"/>
                </row>
                <row>
                    <label value="item 3"/>
                    <label value="item 3 desc"/>
                    <label value="item 3"/>
                </row>
            </rows>
        </grid>
    </window>
</hbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}