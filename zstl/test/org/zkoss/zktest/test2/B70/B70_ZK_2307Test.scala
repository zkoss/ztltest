package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Dimension
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2307.zul")
class B70_ZK_2307Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      // don't support opera
      val originW = getWindowWidth()
      val originH = getWindowHeight()
      setWindowSize(500, originH)
      sleep(500);
      val h5l = jq("$h5").offsetLeft()
      val i5l = jq("$i5").offsetLeft()
      verifyTrue("list head and cell must align to same vertial line.", h5l == i5l);

      setWindowSize(originW, originH)
    })

  }
}