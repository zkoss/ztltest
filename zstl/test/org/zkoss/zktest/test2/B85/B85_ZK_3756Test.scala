package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3756.zul")
class B85_ZK_3756Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verifyContains(jq("@include").text(), "included")
      click(jq("@button"))
      waitResponse()
      verifyEquals(2, jq("@include").length())
      verifyContains(jq("@include:eq(1)").text(), "included")
    })
  }
}
