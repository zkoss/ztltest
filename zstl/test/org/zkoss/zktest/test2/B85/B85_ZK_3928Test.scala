package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3928.zul")
class B85_ZK_3928Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button:contains(Open item-0)"))
      waitResponse()

      click(jq("@button:contains(Select item-0-0-1)"))
      waitResponse()

      val scrollTop = jq("@tree .z-tree-body").scrollTop()
      verifyEquals("The scroll position changes unnecessarily", 0, scrollTop)
    })
  }
}
