package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2290.zul")
class B70_ZK_2290Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      // can't work correctly in ie9, ie10
      // ignore both of them instead.
      val headers = jq(".z-listheader");
      val h1 = headers.eq(1);
      val h6 = headers.eq(6);
      dragdropToObject(h1, h6, h1.width() + ",10", h6.width() + ",10")
      waitResponse()
      verifyTrue("browser should show scrollbar.", hasHScrollbar(jq(".z-listbox-body")));
    })

  }
}