package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author leonlee
  */
@Tags(tags = "B86-ZK-4219.zul")
class B86_ZK_4219Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val header = jq(".z-column").eq(1)
      val clickPosition = (header.offsetLeft() + header.width() - 1) + "," + (header.offsetTop() + 1)
      doubleClickAt(header, clickPosition)
      waitResponse()
      click(jq(".z-button").eq(0))
      waitResponse()
      verifyEquals("true", getZKLog())
    })
  }

}
