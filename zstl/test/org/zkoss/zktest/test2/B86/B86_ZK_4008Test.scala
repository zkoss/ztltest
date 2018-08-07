package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B86-ZK-4008.zul")
class B86_ZK_4008Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit =  {
    runZTL(() => {
      click(jq("@button:contains(append)"))
      waitResponse()

      val widthCell = jq("@row > td:last .z-row-content").width

      click(jq("@button:contains(invalidate)"))
      waitResponse()

      val widthCellInvalidated = jq("@row > td:last .z-row-content").width
      verifyTolerant(widthCell, widthCellInvalidated, 2)
    })
  }
}
