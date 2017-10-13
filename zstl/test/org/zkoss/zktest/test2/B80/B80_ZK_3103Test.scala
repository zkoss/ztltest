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
          verifyEquals("Item 2", jq(".z-listitem-selected div:eq(" + i + ")").text().substring(1))
        }
        click(clearBtn)
        waitResponse(true)
        typeKeys(intbox, "18")
        waitResponse(true)
        click(selBtn)
        waitResponse(true)
        for (i <- 0 to 3) {
          verifyEquals("Item 18", jq(".z-listitem-selected div:eq(" + i + ")").text().substring(1))
        }
        click(clearBtn)
        waitResponse(true)
        typeKeys(intbox, "21")
        waitResponse(true)
        click(selBtn)
        waitResponse(true)
        for (i <- 0 to 3) {
          verifyEquals("Item 21", jq(".z-listitem-selected div:eq(" + i + ")").text().substring(1))
          var lbb = jq(".z-listbox-body").get(i)
          var li = jq(".z-listitem:contains(Item 21)").get(i)
          verifyTrue((lbb.eval("getBoundingClientRect().top")).toDouble + lbb.eval("offsetHeight").toDouble >= li.eval("getBoundingClientRect().top").toDouble + li.eval("offsetHeight").toDouble)
          verifyTrue(lbb.eval("getBoundingClientRect().top").toDouble <= li.eval("getBoundingClientRect().top").toDouble)
        }
        click(clearBtn)
        waitResponse(true)
        typeKeys(intbox, "17")
        waitResponse(true)
        click(selBtn)
        waitResponse(true)
        waitResponse(true)
        for (i <- 0 to 3) {
          verifyEquals("Item 17", jq(".z-listitem-selected div:eq(" + i + ")").text().substring(1))
          var lbb = jq(".z-listbox-body").get(i)
          var li = jq(".z-listitem:contains(Item 17)").get(i)
          verifyTrue(lbb.eval("getBoundingClientRect().top").toDouble + lbb.eval("offsetHeight").toDouble >= li.eval("getBoundingClientRect().top").toDouble + li.eval("offsetHeight").toDouble)
          verifyTrue(lbb.eval("getBoundingClientRect().top").toDouble <= li.eval("getBoundingClientRect().top").toDouble)
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
          verifyEquals(jq(".z-listbox-body").get(i).eval("getBoundingClientRect().top"), jq(".z-listitem:contains(Item 20)").get(i).eval("getBoundingClientRect().top"))
        }
        for (i <- 0 to 2) {
          click(jq(".z-paging-previous i:eq(" + i + ")"))
          waitResponse(true)
        }
        for (i <- 0 to 3) {
          verifyEquals(jq(".z-listbox-body").get(i).eval("getBoundingClientRect().top"), jq(".z-listitem:contains(Item 0)").get(i).eval("getBoundingClientRect().top"))
        }
      }
    )
  }
}
