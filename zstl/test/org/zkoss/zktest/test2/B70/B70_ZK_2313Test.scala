package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2313.zul")
class B70_ZK_2313Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      val b1 = jq("@button:eq(0)");
      val b2 = jq("@button:eq(1)");
      val b3 = jq("@button:eq(2)");
      val lists = jq("@listbox");
      click(b1)
      waitResponse()
      var index = 0
      while (index < 8) { //lists.length()
        val list = lists.eq(index);
        verifyNotEquals("scrolling should be changed after button click.", 0, getScrollTop(list.toWidget()))
        index += 1
      }

      click(b2);
      waitResponse();
      index = 0
      while (index < 8) { //lists.length()
        val list = lists.eq(index);
        verifyEquals("scrolling should be changed after button click.", 0, getScrollTop(list.toWidget()))
        index += 1
      }

      click(b3);
      waitResponse();
      index = 0
      while (index < 8) { //lists.length()
        val list = lists.eq(index);
        verifyNotEquals("scrolling should be changed after button click.", 0, getScrollTop(list.toWidget()))
        index += 1
      }
    })
  }
}