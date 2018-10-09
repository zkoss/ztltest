package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B86-ZK-4004.zul")
class B86_ZK_4004Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val gridWidth = jq("@grid").width()

      click(jq("@button:eq(0)"))
      waitResponse()
      calcColumnWidth(gridWidth)

      click(jq("@button:eq(1)"))
      waitResponse()
      calcColumnWidth(gridWidth)

      click(jq("@button:eq(2)"))
      waitResponse()
      calcColumnWidth(gridWidth)
    })
  }
  def calcColumnWidth(gridWidth: Int): Unit = {
    var width = 0
    val cols = jq("@column").iterator()
    while (cols.hasNext) {
      width += cols.next().width()
    }
    verifyTolerant(gridWidth, width, 3)
  }
}
