package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3589.zul")
class B85_ZK_3589_1Test extends ZTL4ScalaTestCase {
  @Test
  def testScrollOverViewport()=  {
    val zscript = """
     <include src="/test2/B85-ZK-3589.zul"/>
    """
    runZTL(zscript, () => {
      getEval("window.scroll(0, 300)")
      waitResponse()
      val lbl = jq("@label")
      click(lbl)
      waitResponse()
      verifyTrue("The popup should appear!", jq("@popup").isVisible)

      // Click the button that below the red line area
      click(jq("$btnFixed"))
      waitResponse()
      verifyFalse("The popup still appears!", jq("@popup").isVisible)
    })
  }
}
