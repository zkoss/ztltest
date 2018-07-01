
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-139.zul,Flex")
class Z65_Flex_139Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="data flex test: [grid,span,hflex=1,hflex=min,hflex=min]" width="480px">
        <grid>
            <columns>
                <column hflex="1" label="hflex=1"/>
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
        title="data flex test: [grid,hflex=1,hflex=min,hflex=min]" width="480px">
        <grid>
            <columns>
                <column hflex="1" label="hflex=1"/>
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
        title="data flex test: [grid,span,hflex=1,hflex=1,hflex=1]" width="480px">
        <grid>
            <columns>
                <column hflex="1" label="hflex=1"/>
                <column hflex="1" label="hflex=1"/>
                <column hflex="1" label="hflex=1"/>
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
        title="data flex test: [grid,hflex=1,hflex=1,hflex=1]" width="480px">
        <grid>
            <columns>
                <column hflex="1" label="hflex=1"/>
                <column hflex="1" label="hflex=1"/>
                <column hflex="1" label="hflex=1"/>
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