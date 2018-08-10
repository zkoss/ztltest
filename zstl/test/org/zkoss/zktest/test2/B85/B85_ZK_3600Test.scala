package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3600.zul")
class B85_ZK_3600Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val gridHeight = jq("@grid:eq(0) .z-grid-body").scrollHeight()
      val listboxHeight = jq("@listbox:eq(0) .z-listbox-body").scrollHeight()

      click(jq("@button"))
      waitResponse()

      val gridHeight2 = jq("@grid:eq(0) .z-grid-body").scrollHeight()
      val listboxHeight2 = jq("@listbox:eq(0) .z-listbox-body").scrollHeight()

      // ROD dummy height might be inaccurate, so a bigger tolerance is given.
      verifyTolerant(gridHeight, gridHeight2, 100)
      verifyTolerant(listboxHeight, listboxHeight2, 100)
    })
  }
}
