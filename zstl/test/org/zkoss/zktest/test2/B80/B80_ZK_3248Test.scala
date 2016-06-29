package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3248.zul")
class B80_ZK_3248Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val gbBeforeWidth = jq(".z-groupbox").width()
        click(jq(".z-label:contains(\"groupbox 1\")"))
        waitResponse()
        val gbAfterWidth = jq(".z-groupbox").width()
        verifyTrue("Expecting " + gbAfterWidth + " to be smaller than " + gbBeforeWidth, gbAfterWidth < gbBeforeWidth)

        click(jq(".z-label:contains(\"groupbox 1\")"))
        waitResponse()

        val pcBeforeWidth = jq(".z-portalchildren").width()
        click(jq(".z-panel-icon.z-panel-expand").eq(0))
        waitResponse()
        val pcAfterWidth = jq(".z-portalchildren").width()
        verifyTrue("Expecting " + pcAfterWidth + " to be smaller than " + pcBeforeWidth, pcAfterWidth < pcBeforeWidth)
      })
  }
}
