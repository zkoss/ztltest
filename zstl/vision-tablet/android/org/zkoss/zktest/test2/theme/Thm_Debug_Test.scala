package org.zkoss.zktest.test2.theme

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class Thm_Debug_Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        <window id="debugWin" height="200px" width="200px" border="normal">
          Dummy Window
        </window>
        <script defer="true">
          zk.load('zk.debug', function (){
            zDebug.dumpDomTree(zk.Widget.$('$debugWin'));
          }
          );
        </script>
      </zk>"""

    runZTL(zscript,
      () => {
        verifyImage()
      })

  }
}
