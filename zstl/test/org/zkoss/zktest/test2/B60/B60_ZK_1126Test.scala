package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

import scala.collection.JavaConversions._

@Tags(tags = "B60-ZK-1126.zul")
class B60_ZK_1126Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        val tabs = List("ListModelMap", "ListModelSet", "ListModelList")

        tabs.foreach { tab =>
          click(jq(".z-tab:contains(" + tab + ")"))
          waitResponse()

          val panel = jq(".z-tabpanel:visible")
          val btn = panel.find(".z-button")
          val leftBox = panel.find(".z-listbox:eq(0)")
          val rightBox = panel.find(".z-listbox:eq(1)")
          verifyEquals("should see two listboxes side by side", jq(".z-tabpanel:visible .z-listbox").length(), 2)
          verifyEquals("should see left listbox initially populated with data '1'~'4'.", jq(".z-tabpanel:visible .z-listbox .z-listitem").length(), 4)
          verifyEquals("should see two buttons between the listboxes", btn.length(), 2)

          val hlayInn0 = leftBox.parents(".z-hlayout-inner").html()
          val hlayInn1 = btn.parents(".z-hlayout-inner").html()
          val hlayInn2 = rightBox.parents(".z-hlayout-inner").html()

          val hlayChild = jq(".z-hlayout").children().iterator().toList.map(_.html())
          val i0 = hlayChild.indexOf(hlayInn0)
          val i1 = hlayChild.indexOf(hlayInn1)
          val i2 = hlayChild.indexOf(hlayInn2)

          verifyTrue("should see two buttons between the listboxes", i0 < i1)
          verifyTrue("should see two buttons between the listboxes", i1 < i2)

          click(panel.find(".z-listitem-checkbox:eq(0)"))
          waitResponse()
          click(panel.find(".z-listitem-checkbox:eq(2)"))
          waitResponse()
          click(panel.find(".z-listitem-checkbox:eq(3)"))
          waitResponse()

          click(panel.find(".z-button:contains(- >)"))
          waitResponse()
          verifyTrue("should not cause any exceptions to occur.", !jq(".z-window-modal").exists())

          verifyEquals(" should be able to select the data to move in any order.", leftBox.find(".z-listitem").length(), 1)
          verifyEquals(" should be able to select the data to move in any order.", rightBox.find(".z-listitem").length(), 3)

          click(panel.find(".z-listitem-checkbox:eq(3)"))
          waitResponse()

          click(panel.find(".z-button:contains(<-)"))
          waitResponse()

          verifyTrue("should not cause any exceptions to occur.", !jq(".z-window-modal").exists())

          verifyEquals(" should be able to select the data to move in any order.", leftBox.find(".z-listitem").length(), 2)
          verifyEquals(" should be able to select the data to move in any order.", rightBox.find(".z-listitem").length(), 2)

        }

      })

  }
}
