package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3761.zul")
class B85_ZK_3761Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      try {
        click(jq("@button"))
        sleep(1000)
        waitForPageToLoad("5000")

        verifyEquals("breeze", getEval("zk.themeName"))
      } finally {
        click(jq("@button").eq(1))
        sleep(1000)
        waitForPageToLoad("5000")
      }
    })
  }
}
