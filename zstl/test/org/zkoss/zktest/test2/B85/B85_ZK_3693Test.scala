package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B85_ZK_3693Test extends ZTL4ScalaTestCase {

    @Test
    def test() = {
        runZTL(() => {

            scrollDownAndClick("$lb", "$gr")

            verScroll(jq("$lb_m"), .5)
            waitResponse(true)
            verScroll(jq("$gr_m"), .5)
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

        verScroll(listbox, 1)
        waitResponse(true)
        verScroll(grid, 1)
        waitResponse(true)

        val listitems = jq(listboxSelector + " .z-listitem")
        val lastlistitem = listitems.eq(listitems.length() - 1)

        val rows = jq(gridSelector + " .z-row")
        val lastRow = rows.eq(rows.length() - 1)

        try {
            click(lastlistitem)
            waitResponse(true)
            click(lastRow)
            waitResponse(true)
        } catch {
            case _: Exception => verifyFalse(true)
        }
    }
}