package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3844.zul")
class F85_ZK_3844Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      (1 to 4).foreach(i => {
        verifyTrue(s"button $i icon missing",
          jq(s"@button:eq(${i - 1}) i").width > 0)
      })

      // For Screen Reader
      verifyTrue(jq("@label:contains(6. The following)").isVisible)
    })
  }
}
