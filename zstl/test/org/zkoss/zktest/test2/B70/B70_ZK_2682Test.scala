package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2682.zul")
class B70_ZK_2682Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      //open to check items number
      val combobox = jq("@combobox").toWidget
      evalScript(combobox + ".open()") // to show popu first so we can find comboitem in zkmax
      waitResponse()
      val comboitems = jq(combobox).find("@comboitem")
      val grid_rows = jq("@grid:first").find("@row")
      val listbox_items = jq("@listbox:first").find("@listitem")
      var grid_page_rows = jq("@grid:last").find("@row")
      var listbox_page_items = jq("@listbox:last").find("@listitem")

      verifyEquals(2, comboitems.length())
      verifyEquals(2, grid_rows.length())
      verifyEquals(2, listbox_items.length())
      verifyEquals(1, grid_page_rows.length())
      verifyEquals(1, listbox_page_items.length())
      click(jq("@grid:last").find(".z-paging-next"))
      waitResponse()
      grid_page_rows = jq("@grid:last").find("@row")
      verifyEquals(1, grid_page_rows.length())
      click(jq("@listbox:last").find(".z-paging-next"))
      waitResponse()
      listbox_page_items = jq("@listbox:last").find("@listitem")
      verifyEquals(1, listbox_page_items.length())

      //click to check selection sync
      combobox.eval("open()") // to show popu first so we can find comboitem in zkmax
      waitResponse()
      click(comboitems.last)
      waitResponse()
      verifyTrue(listbox_items.last.hasClass("z-listitem-selected"))
      verifyTrue(listbox_page_items.last.hasClass("z-listitem-selected"))
      combobox.eval("open()") // to show popu first so we can find comboitem in zkmax
      waitResponse()
      verifyTrue(comboitems.last.hasClass("z-comboitem-selected"))
    })
  }
}