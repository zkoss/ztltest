package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2746.zul")
class B70_ZK_2746Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
    <include src="/test2/B70-ZK-2746.zul"/>
  """
    runZTL(zscript,
      () => {
        click(jq("@button:first"))
        waitResponse()
        click(jq("@button:last"))
        waitResponse()
        verifyEquals(2, jq(".z-errorbox").length())
      })
  }
}