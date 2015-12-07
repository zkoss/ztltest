package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2752.zul")
class B70_ZK_2752Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
   <include src="/test2/B70-ZK-2752.zul"/>
  """
  runZTL(zscript,
    () => {
      verifyFalse(jq("@grid @row:first").isVisible)
      verifyTrue(jq("@grid @row:last @label").outerHeight < jq("@grid @row:last @textbox").outerHeight)
    })
  }
}