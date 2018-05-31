package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2769.zul")
class B70_ZK_2769Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
    <include src="/test2/B70-ZK-2769.zul"/>
  """
    runZTL(zscript,
      () => {
        val listheader = jq(".z-listheader").eq(0)
        val width_0 = listheader.outerWidth()
        dragdropTo(listheader, (listheader.outerWidth() - 1) + "," + (listheader.outerHeight() / 2), (listheader.outerWidth() + 100) + "," + (listheader.outerHeight() / 2))
        waitResponse(true)
        val width_1 = listheader.outerWidth()
        verifyNotEquals(width_1, width_0)
        verifyEquals(width_1, jq(".z-listcell").eq(0).outerWidth())
        verifyEquals(width_1, jq(".z-listfooter").eq(0).outerWidth())
      })
  }
}