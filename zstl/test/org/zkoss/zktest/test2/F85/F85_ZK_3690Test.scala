package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.JQuery

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3690.zul")
class F85_ZK_3690Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val btns = jq("@button")

      // Listbox
      var elem = jq("@listbox")
      var body = elem.find(".z-listbox-body")
      var rowClz = ".z-listitem"
      click(btns.eq(0))
      waitResponse()
      verifyTolerant(body.height(), getEval("calcRowsHeight('" + rowClz + "')"), 2)
      click(btns.eq(1))
      waitResponse()
      verifyTolerant(body.height(), body.scrollHeight(), 2)

      // Grid
      elem = jq("@grid")
      body = elem.find(".z-grid-body")
      rowClz = ".z-row"
      click(btns.eq(2))
      waitResponse()
      verifyTolerant(body.height(), getEval("calcRowsHeight('" + rowClz + "')"), 2)

      click(btns.eq(3))
      waitResponse()
      verifyTolerant(body.height(), body.scrollHeight(), 2)

      // Tree
      elem = jq("@tree")
      body = elem.find(".z-tree-body")
      rowClz = ".z-treerow"
      click(btns.eq(4))
      waitResponse()
      verifyTolerant(body.height(), getEval("calcRowsHeight('" + rowClz + "')"), 2)

      click(btns.eq(5))
      waitResponse()
      verifyTolerant(body.height(), body.scrollHeight(), 2)
    })
  }
}
