package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * Created by wenning on 5/30/16.
  */
@Tags(tags = "F80-ZK-3161.zul")
class F80_ZK_3161Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(
      () => {
        var tt = jq(".z-west-collapsed").get(0).get("title")
        System.out.println(tt)
        verifyEquals("west title", tt)
        tt = jq(".z-north-collapsed").get(0).get("title")
        System.out.println(tt)
        verifyEquals("", tt)
      }
    )
  }

}
