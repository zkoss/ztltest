package org.zkoss.zktest.test2.B50

import java.util

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers
import org.zkoss.ztl.unit.{ClientWidget, JQuery}

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,safari,edge,ie11,ie10,ie9")
class B50_3337441Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val listitems: JQuery = jq(".z-listitem")
      click(listitems.get(1))
      waitResponse()
      click(listitems.get(1))
      waitResponse()
      var items: util.List[ClientWidget] = new util.ArrayList[ClientWidget]()
      items.add(listitems.get(3))
      shiftClickItems(items)
      verifyEquals(1, jq(".z-listitem-selected").length())
    })
  }
}
