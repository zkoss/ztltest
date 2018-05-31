package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1627.zul")
class B65_ZK_1627Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
<zk>
1. You should not see any exception after the page loaded.
<separator/>
2. Please focus in/out the datebox, you should see an error arrow points to the mid-bottom of the datebox. 
<datebox constraint="no empty, after_end"/>
</zk>
"""
    runZTL(zscript,
      () => {
        verifyFalse("You should not see any exception after the page loaded.", jq(".z-window-modal").exists());

        click(jq(jq(".z-datebox").toWidget().$n("real")))
        waitResponse()
        click(jq(".z-label:eq(0)"))
        waitResponse()
        val db = jq(".z-datebox")
        val dbLeft = db.offsetLeft()
        val pnt = jq(jq(".z-errorbox").toWidget().$n("p"))
        val pntMid = pnt.offsetLeft() + pnt.outerWidth() / 2.0
        verifyTrue("you should see an error arrow points to the mid-bottom of the datebox.", (pntMid - dbLeft - db.outerWidth() / 2.0).abs <= 2)
      })

  }
}