package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2679.zul")
class B70_ZK_2679Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
   <include src="/test2/B70-ZK-2679.zul"/>
  """
    runZTL(zscript,
      () => {
        click(jq(".z-datebox").toWidget().$n("btn"))
        waitResponse()
        click(jq(".z-calendar-right"))
        waitResponse()
        val log = jq("#zk_log").eval("val()")
        verifyFalse(log.contains("invoke beforeUnload"))
      })
  }
}