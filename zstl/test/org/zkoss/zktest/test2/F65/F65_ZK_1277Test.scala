package org.zkoss.zktest.test2.F65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F65-ZK-1277.zul")
class F65_ZK_1277Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      //due to new theme border
      verifyTolerant(jq(".z-row").outerHeight(), jq(".z-group").outerHeight(), 3)
      verifyTolerant(jq(".z-groupfoot").outerHeight(), jq(".z-group").outerHeight(), 3)
      click(jq(".z-button:contains(Autopaging)"))
      waitResponse()
      verifyTolerant(jq(".z-row").outerHeight(), jq(".z-group").outerHeight(), 3)
      verifyTolerant(jq(".z-groupfoot").outerHeight(), jq(".z-group").outerHeight(), 3)
    })
  }
}