package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2978.zul")
class B70_ZK_2978Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val groupboxCaption = jq(".z-caption")
        click(groupboxCaption.eq(1))
        waitResponse(true)
        click(groupboxCaption.eq(0))
        waitResponse(true)

        verifyTrue(hasVScrollbar(jq(".menuGroupboxContainer")))
      })

  }
}