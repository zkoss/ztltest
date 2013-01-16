package org.zkoss.zktest.test2.theme

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class Thm_Tabbox_2_Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?page title="Tabbox" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <window title="Tabbox, tabscroll=false" border="normal" width="300px" height="300px">
                      <tabbox tabscroll="false" height="100%">
                        <tabs>
                          <tab label="Tab 1"/>
                          <tab label="Tab 2"/>
                          <tab label="Tab 3"/>
                        </tabs>
                        <tabpanels>
                          <tabpanel>Tabpanel 1 Content</tabpanel>
                          <tabpanel>Tabpanel 2 Content</tabpanel>
                          <tabpanel>Tabpanel 3 Content</tabpanel>
                        </tabpanels>
                      </tabbox>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyImage()
      })

  }
}
