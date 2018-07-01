package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenning on 5/30/16.
  */
class B80_ZK_3103Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        var selBtn = jq("$select")
        var clearBtn = jq("$clear")
        var intbox = jq("@intbox").get(0)
        typeKeys(intbox, "2")
        waitResponse(true)
        click(selBtn)
        waitResponse(true)
        for (i <- 0 to 3) {
          verifyContains(jq(".z-listitem-selected div:eq(" + i + ")").text(), "Item 2")
        }
        click(clearBtn)
        waitResponse(true)
        typeKeys(intbox, "18")
        waitResponse(true)
        click(selBtn)
        waitResponse(true)
        for (i <- 0 to 3) {
          verifyContains(jq(".z-listitem-selected div:eq(" + i + ")").text(), "Item 18")
        }
        click(clearBtn)
        waitResponse(true)
        typeKeys(intbox, "21")
        waitResponse(true)
        click(selBtn)
        waitResponse(true)
        for (i <- 0 to 3) {
          verifyContains(jq(".z-listitem-selected div:eq(" + i + ")").text(), "Item 21")
          var lbb = jq(".z-listbox-body:eq(" + i + ")")
          var li = jq(".z-listitem:contains(Item 21):eq(" + i + ")")
          verifyTrue(lbb.offsetTop() + lbb.height() >= li.offsetTop() + li.height())
          verifyTrue(lbb.offsetTop() <= li.offsetTop())
        }
        click(clearBtn)
        waitResponse(true)
        typeKeys(intbox, "17")
        waitResponse(true)
        click(selBtn)
        waitResponse(true)
        waitResponse(true)
        for (i <- 0 to 3) {
          verifyContains(jq(".z-listitem-selected div:eq(" + i + ")").text(), "Item 17")
          var lbb = jq(".z-listbox-body:eq(" + i + ")")
          var li = jq(".z-listitem:contains(Item 17):eq(" + i + ")")
          verifyTrue(lbb.offsetTop() + lbb.height() >= li.offsetTop() + li.height())
          verifyTrue(lbb.offsetTop() <= li.offsetTop())
        }
        for (i <- 0 to 3) {
          verScroll(jq(".z-listbox").get(i), 0)
          waitResponse(true)
        }
        for (i <- 0 to 3) {
          verScroll(jq(".z-listbox").get(i), 0)
          waitResponse(true)
        }
        for (i <- 0 to 2) {
          click(jq(".z-paging-next i:eq(" + i + ")"))
          waitResponse(true)
        }
        for (i <- 0 to 3) {
          var lbb = jq(".z-listbox-body:eq(" + i + ")")
          var li = jq(".z-listitem:contains(Item 20):eq(" + i + ")")
          verifyEquals(lbb.offsetTop(), li.offsetTop())
        }
        for (i <- 0 to 2) {
          click(jq(".z-paging-previous i:eq(" + i + ")"))
          waitResponse(true)
        }
        for (i <- 0 to 3) {
          var lbb = jq(".z-listbox-body:eq(" + i + ")")
          var li = jq(".z-listitem:contains(Item 0):eq(" + i + ")")
          verifyEquals(lbb.offsetTop(), li.offsetTop())
        }
      }
    )
  }
}
