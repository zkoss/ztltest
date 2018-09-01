package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3656.zul")
class B85_ZK_3656Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      val headerCm = jq(".z-listheader-checkable:eq(0)")
      click(headerCm)
      waitResponse()
      verifyTrue("The header checkbox status is wrong. (It should be checked)", headerCm.hasClass("z-listheader-checked"))

      val rowHeight = jq(".z-listitem").outerHeight
      val listBody = jq("@listbox .z-listbox-body")
      val cm = jq(".z-listitem-checkbox > i")
      verScrollAbs(listBody, rowHeight * 17) // just shows item 20
      waitResponse()
      verifyTrue("The 20th checkbox status is wrong. (It should be checked)", cm.eq(20).isVisible)

      verScrollAbs(listBody, rowHeight * 40) // just shows item 44
      waitResponse()
      verifyTrue("The 44th checkbox status is wrong. (It should be checked)", cm.eq(44).isVisible)
    })
  }
}
