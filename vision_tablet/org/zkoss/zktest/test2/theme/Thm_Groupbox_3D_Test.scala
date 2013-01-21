package org.zkoss.zktest.test2.theme

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class Thm_Groupbox_3D_Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?page title="Groupbox 3D" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <hbox>
                      <groupbox width="300px" height="300px" mold="3d">
                        <caption image="/common/img/volumn.gif" label="Caption"/>
                        Groupbox Content
                      </groupbox>
                      <groupbox width="300px" height="300px" mold="3d">
                        <caption label="Caption"/>
                        Groupbox Content
                      </groupbox>
                    </hbox>
                    <separator/>
                    <hbox>
                      <groupbox width="300px" height="300px" mold="3d">
                        <caption image="/common/img/volumn.gif"/>
                        Groupbox Content
                      </groupbox>
                      <groupbox width="300px" height="300px" mold="3d">
                        Groupbox Content
                      </groupbox>
                    </hbox>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyImage()
      })

  }
}
