package org.zkoss.zktest.test2.B95

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("chrome,ff,ie11,ie10,ie9,edge,ios,android")
class B95_ZK_4322Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val lb1 = jq("@listbox:eq(0)")
      val lb2 = jq("@listbox:eq(1)")
      val width1 = lb1.find(".z-listbox-body").height()
      val width2 = lb1.find(".z-listbox-body").height()
      click(jq("@button:eq(0)"))
      verifyEquals(width1, lb1.find(".z-listbox-body").height())
      verifyEquals(width2, lb2.find(".z-listbox-body").height())
      click(jq("@button:eq(1)"))
      verifyEquals(width1, lb1.find(".z-listbox-body").height())
      verifyEquals(width2, lb2.find(".z-listbox-body").height())
      click(jq("@button:eq(2)"))
      verifyEquals(width1, lb1.find(".z-listbox-body").height())
      verifyEquals(width2, lb2.find(".z-listbox-body").height())
    })
  }
}
