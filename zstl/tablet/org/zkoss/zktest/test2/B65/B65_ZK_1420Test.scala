package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class B65_ZK_1420Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
<label multiline="true">
Textbox must render correctly, especially on android 2.x
The value of Textbox is zk.android
</label>
<textbox value="${zk.android}" />
</zk>
    """

    runZTL(zscript,
      () => {
        verifyTrue("The value of Textbox is zk.android", jq(".z-textbox").`val`().charAt(0).toInt >= 4)
      })

  }
}
