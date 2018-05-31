package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F70-ZK-1721.zul")
class F70_ZK_1721Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	Click the button it should redirect to F70-ZK-1721-1.zul correctly.
	<button label="redirect" onClick='Executions.getCurrent().sendRedirect("test2/F70-ZK-1721-1.zul", true)' />
</zk>
"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"))
        sleep(2000)
        verifyTrue("should redirect to F70-ZK-1721-1.zul correctly.", jq(".z-label:contains(Destination)").exists)
      })

  }
}