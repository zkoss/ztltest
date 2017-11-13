package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 31/10/2017.
  */
class B80_ZK_3231Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-listitem-checkbox").get(0))
      waitResponse(true)
      verifyEquals(1, jq(".z-intbox").text())
      click(jq(".z-icon-angle-right").get(0))
      waitResponse(true)
      click(jq(".z-listitem-checkbox").get(0))
      waitResponse(true)
      verifyEquals(2, jq(".z-intbox").text())
    })
  }

}
