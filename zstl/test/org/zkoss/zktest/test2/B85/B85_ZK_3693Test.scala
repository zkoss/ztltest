package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B85_ZK_3693Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(() => {
      scrollDownAndClick("$lb", "$gr")
      verScroll(jq("$lb_m"), 50)
      waitResponse(true)
      verScroll(jq("$gr_m"), 50)
      waitResponse(true)
      val buttons = jq("@button")
      click(buttons.eq(0))
      waitResponse(true)
      click(buttons.eq(1))
      waitResponse(true)
      scrollDownAndClick("$lb_m", "$gr_m")
    })
  }

  def scrollDownAndClick(listboxSelector: String, gridSelector: String) = {
    val listbox = jq(listboxSelector)
    val grid = jq(gridSelector)
    verScroll(listbox, 100)
    waitResponse(true)
    verScroll(grid, 100)
    waitResponse(true)
    val rows = jq(gridSelector).find(".z-row")
    click(jq(listboxSelector).find(".z-listitem").last())
    waitResponse(true)
    click(rows.last())
    waitResponse(true)
  }
}