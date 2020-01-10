package org.zkoss.zktest.test2.F90

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery

/**
  * @author rudyhuang
  */
class F90_ZK_4470Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      testOverflow(jq(widget("@treecol:eq(0)").$n("cave")))
      testOverflow(jq(widget("@treecol:eq(1)").$n("cave")))

      testOverflow(jq(widget("@listheader:eq(0)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(1)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(2)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(3)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(23)").$n("cave")))

      click(jq("@listheader:eq(3)"))
      waitResponse()

      testOverflow(jq(widget("@listheader:eq(0)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(1)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(2)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(3)").$n("cave")))
      testOverflow(jq(widget("@listheader:eq(23)").$n("cave")))
    })
  }

  def testOverflow(elem: JQuery): Unit = {
    verifyTrue("The content is overflowed!", elem.scrollWidth() <= elem.outerWidth())
  }
}
