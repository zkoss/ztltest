
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-024.zul,Flex")
class Z65_Flex_024Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Tabbox, Hlayout]" width="480px">
        <hlayout vflex="min" width="200px">
            <tabbox hflex="1" vflex="1">
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
            <tabbox height="60px" hflex="1">
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
            <tabbox height="100px" hflex="1">
                <tabs>
                    <tab label="case"/>
                </tabs>
                <tabpanels>
                    <tabpanel>
                        <div height="100%" style="background:red" width="100%">
                            <label value="1"/>
                        </div>
                    </tabpanel>
                </tabpanels>
            </tabbox>
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Tabbox, Hbox]" width="480px">
        <hbox vflex="min" width="200px">
            <tabbox hflex="1" vflex="1">
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
            <tabbox height="60px" hflex="1">
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
            <tabbox height="100px" hflex="1">
                <tabs>
                    <tab label="case"/>
                </tabs>
                <tabpanels>
                    <tabpanel>
                        <div height="100%" style="background:red" width="100%">
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