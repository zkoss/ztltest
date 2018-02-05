package org.zkoss.zktest.test2.F60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F60-ZK-1583.zul")
class F60_ZK_1583Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        //, "before_center", "before_end", "after_start", "after_center", "after_end", "start_before", "start_center", "start_after", "end_before", "end_center", "end_after"
        List("before_start") foreach { pos =>
          click(jq(".z-radio input[value=\"" + pos + "\"]"))
          waitResponse(true)
          Map("info" -> "green", "warning" -> "yellow", "error" -> "red") foreach {
            case (notifyType, color) =>
              click(jq(".z-button:contains(" + notifyType + ")"))
              waitResponse(true)
              val div = jq("div[style*=" + color + "]")
              val pointer = jq(".z-notification-pointer")
              val divLeftMid = div.offsetLeft() + 0.5 * div.width()
              val pointerLeftMid = pointer.offsetLeft() + 0.5 * pointer.width()
              val divTopMid = div.offsetTop() + 0.5 * div.height()
              val pointerTopMid = pointer.offsetTop() + 0.5 * pointer.height()
              var msg = ">>>" + pos + ":" + notifyType + ", " + ", "
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