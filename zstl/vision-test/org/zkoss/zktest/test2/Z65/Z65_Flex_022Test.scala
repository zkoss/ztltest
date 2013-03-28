
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-022.zul,Flex")
class Z65_Flex_022Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Tabbox, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <tabbox hflex="1" vflex="1">
                <tabs>
                    <tab label="case"/>
                </tabs>
                <tabpanels>
                    <tabpanel>
                        <div height="100%" style="background:cyan" width="100%">
                            <label value="1"/>
                        </div>
                    </tabpanel>
                </tabpanels>
            </tabbox>
            <tabbox hflex="2" vflex="1">
                <tabs>
                    <tab label="case"/>
                </tabs>
                <tabpanels>
                    <tabpanel>
                        <div height="100%" style="background:yellow" width="100%">
                            <label value="1"/>
                        </div>
                    </tabpanel>
                </tabpanels>
            </tabbox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Tabbox, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <tabbox hflex="1" vflex="1">
                <tabs>
                    <tab label="case"/>
                </tabs>
                <tabpanels>
                    <tabpanel>
                        <div height="100%" style="background:cyan" width="100%">
                            <label value="1"/>
                        </div>
                    </tabpanel>
                </tabpanels>
            </tabbox>
            <tabbox hflex="2" vflex="1">
                <tabs>
                    <tab label="case"/>
                </tabs>
                <tabpanels>
                    <tabpanel>
                        <div height="100%" style="background:yellow" width="100%">
                            <label value="1"/>
                        </div>
                    </tabpanel>
                </tabpanels>
            </tabbox>
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