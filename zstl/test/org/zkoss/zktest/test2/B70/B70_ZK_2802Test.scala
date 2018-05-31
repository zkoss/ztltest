package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2802.zul")
class B70_ZK_2802Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
   <include src="/test2/B70-ZK-2802.zul"/>
  """
    runZTL(zscript,
      () => {
        verifyTrue(jq("@toolbarbutton:first").outerHeight() > jq("@toolbarbutton:first img").outerHeight())
        verifyTrue(jq("@toolbarbutton:first").outerWidth() > jq("@toolbarbutton:first img").outerWidth())
      })
  }
}