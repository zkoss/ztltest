
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-025.zul,Flex")
class Z65_Flex_025Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="minimum Flex: [Tabbox, Vlayout]" width="480px">
        <vlayout height="200px" hflex="min">
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
            <tabbox vflex="1" width="75px">
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
            <tabbox vflex="1" width="120px">
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
        </vlayout>
    </window>
    <window border="normal" height="360px"
        title="minimum Flex: [Tabbox, Vbox]" width="480px">
        <vbox height="200px" hflex="min">
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
            <tabbox vflex="1" width="75px">
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
            <tabbox vflex="1" width="120px">
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