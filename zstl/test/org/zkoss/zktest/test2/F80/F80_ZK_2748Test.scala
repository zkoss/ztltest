package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * Created by wenning on 5/30/16.
  */
@Tags(tags = "F80-ZK-2748.zul")
class F80_ZK_2748Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(
      () => {
        val lb1 = jq("@label").get(1).get("offsetTop")
        val lb2 = jq("@label").get(2).get("offsetTop")
        verifyEquals(lb1, lb2)
      }
    )
  }

}
