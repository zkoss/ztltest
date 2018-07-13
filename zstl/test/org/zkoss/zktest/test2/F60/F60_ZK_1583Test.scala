package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F60-ZK-1583.zul")
class F60_ZK_1583Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var posList = List("before_start", "before_center", "before_end", "after_start", "after_center", "after_end", "start_before", "start_center", "start_after", "end_before", "end_center", "end_after")
        for (pos <- posList) {
          click(jq(".z-radio input[value=\"" + pos + "\"]"))
          waitResponse(true)
          var statusList = List("info", "warning", "error")
          var colorList = List("green", "yellow", "red")
          for (i <- 0 to 2) {
            click(jq(".z-button:contains(" + statusList(i) + ")"))
            waitResponse(true)
            val div = jq("div[style*=" + colorList(i) + "]")
            val pointer = jq(".z-notification-pointer")
            val divLeftMid = div.offsetLeft() + 0.5 * div.width()
            val pointerLeftMid = pointer.offsetLeft() + 0.5 * pointer.width()
            val divTopMid = div.offsetTop() + 0.5 * div.height()
            val pointerTopMid = pointer.offsetTop() + 0.5 * pointer.height()
            var msg = ">>>" + pos + ":" + statusList(i) + ", "
            if (pos.startsWith("b") || pos.startsWith("a")) {
              msg = msg + divLeftMid + ", " + pointerLeftMid + ". Should see the ARROW of notification point to center"
              println(msg)
              verifyTrue(msg, (divLeftMid - pointerLeftMid).abs < 11)
            } else {
              msg = msg + divTopMid + ", " + pointerTopMid + ". Should see the ARROW of notification point to center"
              verifyTrue(msg, (divTopMid - pointerTopMid).abs < 11)
            }
            waitResponse(true)
          }
        }
      })
  }
}