package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B86_ZK_3985Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      var listboxHeight: String = jq(".z-listbox").height().toString()
      click(jq(".z-listcell").eq(0))
      waitResponse()
      verifyContains(getZKLog(), listboxHeight)
    })
  }
}
